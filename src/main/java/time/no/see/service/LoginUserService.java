package time.no.see.service;


import time.no.see.model.beans.User;
import time.no.see.model.beans.user.Sys_User;

public interface LoginUserService {

	Sys_User getUserByUsername(String username);

}
