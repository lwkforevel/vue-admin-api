package time.no.see.view.user.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import are.you.ok.model.result.BaseResult;
import are.you.ok.model.result.token.Token;
import are.you.ok.model.result.user.UserInfo;
import time.no.see.mapper.role.Sys_RoleMapper;
import time.no.see.mapper.user.Sys_UserMapper;
import time.no.see.model.beans.role.Sys_Role;
import time.no.see.service.user.Sys_UserService;

@Service
public class Sys_UserServiceImpl implements Sys_UserService{
	
	@Autowired
	private Sys_UserMapper sys_UserMapper;
	
	@Autowired
	private Sys_RoleMapper sys_RoleMapper;
	
	@Override
	public BaseResult<UserInfo> getUserInfo(Token token) throws JsonParseException, JsonMappingException, IOException {
		String username = token.getUsername();
		Long roleId = sys_UserMapper.selectRoleIdByUsername(username);
		Sys_Role sys_Role = sys_RoleMapper.selectByPrimaryKey(roleId);
		BaseResult<UserInfo> initUserInfo = initUserInfo(sys_Role);
		return initUserInfo;
	}
	
	private BaseResult<UserInfo> initUserInfo(Sys_Role sys_Role) throws JsonParseException, JsonMappingException, IOException{
		BaseResult<UserInfo> baseResult = new BaseResult<UserInfo>(new UserInfo());
		UserInfo data = baseResult.getData();
		
		data.setAvatar(sys_Role.getAvatar());
		data.setIntroduction(sys_Role.getIntroduction());
		data.setName(sys_Role.getName());
		data.setPermission(sys_Role.getPermission());
		return baseResult;
	}
	
}
