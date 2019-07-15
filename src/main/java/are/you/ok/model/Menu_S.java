package are.you.ok.model;

import java.util.List;
import java.util.Map;

public class Menu_S {
//	  path: '/example',
//	    component: ()=>import('@/layout'),
//	    redirect: '/example/table',
//	    name: 'Example',
//	    meta: { title: 'Example', icon: 'example' },
//	    children: [
//	      {
//	        path: 'table',
//	        name: 'Table',
//	        component: () => import('@/views/table/index'),
//	        meta: { title: 'Table', icon: 'table' }
//	      },
//	      {
//	        path: 'tree',
//	        name: 'Tree',
//	        component: () => import('@/views/tree/index'),
//	        meta: { title: 'Tree', icon: 'tree' }
//	      }
//	    ]
	private String path;
	private String component;
	private String name;
	private Map<String,String> meta;
	private List<Menu_S> children;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getMeta() {
		return meta;
	}
	public void setMeta(Map<String, String> meta) {
		this.meta = meta;
	}
	public List<Menu_S> getChildren() {
		return children;
	}
	public void setChildren(List<Menu_S> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Menu_S [path=" + path + ", component=" + component + ", name=" + name + ", meta=" + meta + ", children="
				+ children + "]";
	}
	
	
}
