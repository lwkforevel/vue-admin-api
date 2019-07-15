package time.no.see.view.menu;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import are.you.ok.model.Menu_S;
import are.you.ok.model.result.BaseResult;
import time.no.see.mapper.resources.Sys_ResourceMapper;
import time.no.see.model.beans.resources.Sys_Resource;

@Controller
public class Menu_Scontroller {
	
	@Autowired
	Sys_ResourceMapper sys_ResourceMapper;
	
	
	@ResponseBody
	@RequestMapping("menu/menu_list")
	public BaseResult<List<Menu_S>> menu_list() {
		List<Sys_Resource> sys_Resources = sys_ResourceMapper.selectByParent_Id((long)1);
		List<Sys_Resource> menu_menu = menu_menu(sys_Resources);
		List<Menu_S> menu_Ss = menuTomenS(menu_menu);
		BaseResult<List<Menu_S>> results = new BaseResult<List<Menu_S>>();
		results.setCode(20000);
		results.setData(menu_Ss);
		return results;
	}
	//[Sys_Resource [id=11, name=组织机构管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=organization:*, checked=null, path=/organization, available=true, children=null], Sys_Resource [id=21, name=用户管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=user:*, checked=null, path=/user, available=true, children=null], Sys_Resource [id=31, name=资源管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=resource:*, checked=null, path=/resource, available=true, children=null], Sys_Resource [id=41, name=角色管理, type=menu, url=@/layout, parentId=1, parentIds=0/1/, permission=role:*, checked=null, path=/role, available=true, children=null]]

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
