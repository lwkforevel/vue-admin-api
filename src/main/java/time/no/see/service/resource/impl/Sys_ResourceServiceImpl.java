package time.no.see.service.resource.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import are.you.ok.model.Menu_S;
import are.you.ok.model.ResourceAndPermission;
import are.you.ok.utils.resource.Resource_HasPermissionUtil;
import time.no.see.mapper.resources.Sys_ResourceMapper;
import time.no.see.model.beans.resources.Sys_Resource;
import time.no.see.service.resource.Sys_ResourceService;
import time.no.see.view.menu.UDFunction;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:mybatis.cfg.xml",
        "classpath:spring-beans.xml"})
@Service
public class Sys_ResourceServiceImpl implements Sys_ResourceService{

	@Autowired
	Sys_ResourceMapper sys_ResourceMapper;
	
	
	public List<Menu_S> resourceHasPermission(String permissions) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		//String permissions;
		Resource_HasPermissionUtil resource_HasPermissionUtil = new Resource_HasPermissionUtil();
		List<ResourceAndPermission> extraPermissions = resource_HasPermissionUtil.extraPermissions(permissions);
		List<Sys_Resource> filterResourceHasPermission = filterResourceHasPermission(extraPermissions);
		List<Menu_S> filterMenuS = menuTomenS(filterResourceHasPermission);
		return filterMenuS;
	}

	@Test
	public void WritefiterResourceToJson() throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		//String permissions;
		String permissions = "[{\"id\":11,\"name\":\"organization\",\"permission\":[\"update\"]},{\"id\":21,\"name\":\"user\",\"permission\":[\"view\"]},{\"id\":31,\"name\":\"resource\",\"permission\":[\"update\"]},{\"id\":41,\"name\":\"role\",\"permission\":[\"create\",\"delete\"]}]";
		Resource_HasPermissionUtil resource_HasPermissionUtil = new Resource_HasPermissionUtil();
		List<ResourceAndPermission> extraPermissions = resource_HasPermissionUtil.extraPermissions(permissions);
		List<Sys_Resource> filterResourceHasPermission = filterResourceHasPermission(extraPermissions);
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(filterResourceHasPermission);
		System.out.println(writeValueAsString);
	}
	
	private List<Sys_Resource> filterResourceHasPermission(List<ResourceAndPermission> resourceAndPermissions) {
		List<Sys_Resource> finalT = new ArrayList<Sys_Resource>();
		for(ResourceAndPermission resourceAndPermission:resourceAndPermissions) {
			Sys_Resource primarySys_Resource = sys_ResourceMapper.selectByPrimaryKey((long)resourceAndPermission.getId());
			List<Sys_Resource> sys_Resources = sys_ResourceMapper.selectByParent_Id(resourceAndPermission.getId());
			List<Sys_Resource> sys_ResourcesHasPermissions = sys_Resources.stream().filter(resource ->hasPermission(resourceAndPermission.getPermission(), resource)).collect(Collectors.toList());
			primarySys_Resource.setChildren(sys_ResourcesHasPermissions);
			finalT.add(primarySys_Resource);
		}
		return finalT;
	}
	
	
	  private boolean hasPermission(Set<String> permissions, Sys_Resource resource) {
	        if(StringUtils.isEmpty(resource.getPermission())) {
	            return true;
	        }
	        for(String permission : permissions) {
	            WildcardPermission p1 = new WildcardPermission(permission);
	            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
	            if(p1.implies(p2) || p2.implies(p1)) {
	                return true;
	            }
	        }
	        return false;
	    }
	
	private List<Sys_Resource> menu_menu(List<Sys_Resource> sys_Resources){
		for(Sys_Resource sys_Resource : sys_Resources) {
			List<Sys_Resource> children = sys_ResourceMapper.selectByParent_Id(sys_Resource.getId());
			if(children.size()!=0) {
			sys_Resource.setChildren(children);
			}
				menu_menu(children);
		}
		return sys_Resources;
	}
	
	
	private List<Menu_S> menuTomenS(List<Sys_Resource> sys_Resources){
		List<Menu_S> menu_Ss = sys_Resources.stream().map(new UDFunction()).collect(Collectors.toList());
		return menu_Ss;
	}

}
