package time.no.see.view.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import time.no.see.mapper.role.Sys_RoleMapper;
import time.no.see.mapper.user.Sys_UserMapper;
import time.no.see.model.beans.role.Sys_Role;
import time.no.see.model.beans.user.Sys_User;
import time.no.see.view.user.Sys_RoleService;

@Service
public class Sys_UserServiceImpl implements Sys_RoleService{

	@Autowired
	Sys_UserMapper sys_UserMapper;
	
	@Autowired
	Sys_RoleMapper sys_RoleMapper;
	

	@Override
	public Sys_Role findSys_RoleByUsername(String username) {
		Sys_User sys_User = sys_UserMapper.getSys_UserByUsername(username);
		Sys_Role sys_Role = sys_RoleMapper.selectByPrimaryKey(sys_User.getId());
		return sys_Role;
	}


	
	
}
