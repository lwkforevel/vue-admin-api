package time.no.see.view.menu;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import are.you.ok.model.Menu_S;
import are.you.ok.model.result.BaseResult;
import time.no.see.service.resource.Sys_ResourceService;

@Controller
public class Menu_Scontroller {

	@Autowired
	Sys_ResourceService sys_ResourceService;
	
	
	@ResponseBody
	@RequestMapping("menu/menu_list")
	public BaseResult<List<Menu_S>> menu_list(String permissions) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		permissions = URLDecoder.decode(permissions,"UTF-8");
		System.out.println(permissions);
		permissions = permissions.substring(1,permissions.length()-1).replace("\\\"", "\"");
		System.out.println(permissions);
		List<Menu_S> resourceHasPermission = sys_ResourceService.resourceHasPermission(permissions);
		BaseResult<List<Menu_S>> results = new BaseResult<List<Menu_S>>();
		results.setCode(20000);
		results.setData(resourceHasPermission);
		System.out.println(results);
		return results;
	}
	//[Sys_Resource [id=11, name=组织机构管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=organization:*, checked=null, path=/organization, available=true, children=null], Sys_Resource [id=21, name=用户管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=user:*, checked=null, path=/user, available=true, children=null], Sys_Resource [id=31, name=资源管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=resource:*, checked=null, path=/resource, available=true, children=null], Sys_Resource [id=41, name=角色管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=role:*, checked=null, path=/role, available=true, children=null]]

}
