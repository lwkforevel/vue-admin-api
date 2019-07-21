package time.no.see.view.user;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import are.you.ok.model.result.BaseResult;
import are.you.ok.model.result.token.Token;
import are.you.ok.model.result.user.UserInfo;
import time.no.see.service.user.Sys_UserService;

@Controller
public class UserController {
	
	@Autowired
	private Sys_UserService sys_userService;
	
	@ResponseBody
	@RequestMapping("user/info")
	public BaseResult<UserInfo> getUserInfo(Token token) throws JsonParseException, JsonMappingException, IOException {
		BaseResult<UserInfo> userInfo = sys_userService.getUserInfo(token);
		return userInfo;
	}
	
}	
