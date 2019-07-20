package time.no.see.view.user;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import are.you.ok.model.result.token.Token;
import are.you.ok.model.result.user.Result_UserInfo;

@Controller
public class UserController {
	
	
	@ResponseBody
	@RequestMapping("user/info")
	public Result_UserInfo getUserInfo(Token token) {
		Result_UserInfo result_userinfo = new Result_UserInfo();
		return result_userinfo;
	}
	
}	
