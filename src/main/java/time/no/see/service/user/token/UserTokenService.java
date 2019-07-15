package time.no.see.service.user.token;

import are.you.ok.model.result.token.Result_Token;
import time.no.see.model.beans.user.Sys_User;

public interface UserTokenService {

	Result_Token generateToken(Sys_User userLogin);

}
