package time.no.see.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import time.no.see.mapper.role.Sys_RoleMapper;
import time.no.see.model.beans.role.Sys_Role;
import time.no.see.service.role.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
	@Autowired
	Sys_RoleMapper sys_RoleMapper;
	
	
	@Override
	public Sys_Role findSysRoleById(Long id) {
		System.out.println(id);
		Sys_Role sys_Role = sys_RoleMapper.findSysRoleById(id);
		System.out.println(sys_Role);
		return sys_Role;
	}

}
