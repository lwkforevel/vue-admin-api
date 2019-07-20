package time.no.see.service.user.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import are.you.ok.entry.EncryHelper;
import time.no.see.mapper.user.Sys_UserMapper;
import time.no.see.model.beans.role.Sys_Role;
import time.no.see.model.beans.user.Sys_User;
import time.no.see.service.user.login.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	final String salt = "salt";
	
	@Autowired
	private Sys_UserMapper sys_userMapper;
	

	@Override
	public Sys_User userLogin(Sys_User user) {
		Sys_User dbUser = sys_userMapper.getSys_UserByUsername(user.getUsername());
		EncryHelper encryHelper = new EncryHelper();
		String encryptPassword = encryHelper.encryptPassword(user.getPassword(), dbUser.getSalt());
		user.setPassword(encryptPassword);
		return (user.getPassword().equals(encryptPassword))? user:null;
	}


	@Override
	public Sys_Role findPermission(String username) {
		
		return null;
	}

}
