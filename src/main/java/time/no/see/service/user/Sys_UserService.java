package time.no.see.service.user;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import are.you.ok.model.result.BaseResult;
import are.you.ok.model.result.token.Token;
import are.you.ok.model.result.user.UserInfo;

public interface Sys_UserService {

	BaseResult<UserInfo> getUserInfo(Token token) throws JsonParseException, JsonMappingException, IOException;

}
