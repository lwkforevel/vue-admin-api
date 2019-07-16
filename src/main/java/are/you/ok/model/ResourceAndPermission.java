package are.you.ok.model;

import java.util.Set;

public class ResourceAndPermission {
	
	private Integer id;
	private Set<String> permission;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<String> getPermission() {
		return permission;
	}
	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "ResourceAndPermission [id=" + id + ", permission=" + permission + "]";
	}
	
}
