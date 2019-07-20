package time.no.see.view.user.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import are.you.ok.model.result.BaseResult;
import are.you.ok.model.result.token.Token;


@Controller
public class LoginController {
		
	
	
	@ResponseBody
	@RequestMapping("/user/login")
	public BaseResult<Token> userLogin(String username,String password) {
		System.out.println(username +"=============="+password);
	    BaseResult<Token> base_token = userLogin_(username,password);
	    return base_token;
	}
	
	
	private  BaseResult<Token> userLogin_(String username,String password) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		BaseResult<Token> base_token = new BaseResult<Token>();
		subject.login(usernamePasswordToken);
		//如果没有异常则证明密码验证成功,返回用户名--token
		base_token.getData().setUsername(username);
		return base_token;
	}
	
}
