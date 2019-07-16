package time.no.see.view.user.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import are.you.ok.model.result.TToken;
import are.you.ok.model.result.token.Result_Token;
import time.no.see.model.beans.role.Sys_Role;
import time.no.see.model.beans.user.Sys_User;
import time.no.see.view.user.Sys_RoleService;


@Controller
public class LoginController {
		
	/*@RequestMapping("/user/login")
	public Result_Token userLogin(Sys_User user) {
		Sys_User userLogin = userLoginService.userLogin(user);
		Result_Token result_Token = userTokenService.generateToken(userLogin);
		return result_Token;
	}
	*/
	@Autowired
	Sys_RoleService sys_RoleService;
	
	
	@ResponseBody
	@RequestMapping("/user/login")
	public Result_Token userLogin(Sys_User user) {
	    Subject subject = SecurityUtils.getSubject();
        Result_Token result_Token = new Result_Token();
        TToken tToken = new TToken();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
           Sys_Role role = sys_RoleService.findSys_RoleByUsername(user.getUsername());
           tToken.setPrivilege(role.getPermission());
        } catch (UnknownAccountException e) {
        	result_Token.setCode(0000000);
        } catch (IncorrectCredentialsException e) {
        	result_Token.setCode(000000);
        }
        //ÔOÖÃTOKEN
        tToken.setToken(user.getUsername());
        result_Token.setToken(tToken);
        result_Token.setCode(20000);
        //ƒ¦´æSessionµ½·þ„Õ¶Ë
        subject.getSession().setAttribute("token", tToken);
        return result_Token;
	}
}
