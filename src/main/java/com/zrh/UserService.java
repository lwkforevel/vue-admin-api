package com.zrh;

import java.util.List;

public interface UserService {

	void regist(User user);

	User findUser(String primaryPrincipal);

	List<Role> findRole();

}
