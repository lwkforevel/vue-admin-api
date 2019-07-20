package time.no.see.service.user.login;

import time.no.see.model.beans.role.Sys_Role;
import time.no.see.model.beans.user.Sys_User;

public interface UserLoginService {

	Sys_User userLogin(Sys_User user);

	Sys_Role findPermission(String username);

}
