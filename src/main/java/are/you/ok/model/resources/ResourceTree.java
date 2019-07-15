package are.you.ok.model.resources;

import java.util.List;

public class ResourceTree {
	
	private Integer id;
	private String name;
	private List<String> permission;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPermission() {
		return permission;
	}
	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "ResourceTree [id=" + id + ", name=" + name + ", permission=" + permission + "]";
	}
	
}
