package time.no.see.view.user;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import are.you.ok.model.result.TToken;
import are.you.ok.model.result.user.Result_UserInfo;
import are.you.ok.model.result.user.UserInfo;

@Controller
public class UserController {
	
	private static Map<String,UserInfo> userInfo = new HashMap<String,UserInfo>();
	static {
		UserInfo user1 = new UserInfo("I am a super administrator","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","Super Admin");
		UserInfo user2 = new UserInfo("I am an editor","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","Normal Editor");
		userInfo.put("admin", user1);
		userInfo.put("life", user2);
	}
	
	@ResponseBody
	@RequestMapping("user/info")
	public Result_UserInfo getUserInfo(TToken token) {
		Result_UserInfo result_userinfo = new Result_UserInfo();
		UserInfo userInfo2 = userInfo.get(token.getToken());
		result_userinfo.setCode(20000);
		result_userinfo.setUserInfo(userInfo2);
		return result_userinfo;
	}
}	
