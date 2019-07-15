package time.no.see.view.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import are.you.ok.model.Menu_S;
import time.no.see.model.beans.resources.Sys_Resource;

public class UDFunction implements Function<Sys_Resource, Menu_S>{

	@Override
	public Menu_S apply(Sys_Resource sys_resource) {
		Menu_S menu_S = new Menu_S();
		menu_S.setName(sys_resource.getName());
		menu_S.setComponent(sys_resource.getUrl());
		menu_S.setPath(sys_resource.getPath());
		Map<String,String> map = new HashMap<String,String>();
		map.put("title", sys_resource.getName());
		menu_S.setMeta(map);
		List<Sys_Resource> children = sys_resource.getChildren();
		if(children!=null) {
			List<Menu_S> collect = children.stream().map(new UDFunction()).collect(Collectors.toList());
			menu_S.setChildren(collect);
		}
		return menu_S;
	}

}
