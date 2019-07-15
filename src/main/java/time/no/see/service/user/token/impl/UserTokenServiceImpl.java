package time.no.see.service.user.token.impl;

import org.springframework.stereotype.Service;

import are.you.ok.model.result.TToken;
import are.you.ok.model.result.token.Result_Token;
import time.no.see.model.beans.user.Sys_User;
import time.no.see.service.user.token.UserTokenService;

@Service
public class UserTokenServiceImpl implements UserTokenService{
	
	
	
	@Override
	public Result_Token generateToken(Sys_User user) {
		Result_Token result_token = new Result_Token();
		result_token.setCode(20000);
		TToken token_ = new TToken();
		token_.setToken(String.valueOf(user.getId()));
		result_token.setToken(token_);
		return result_token;
	}
	
}
