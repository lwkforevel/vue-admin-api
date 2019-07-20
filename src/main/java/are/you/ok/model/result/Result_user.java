package are.you.ok.model.result;

import java.util.List;

import time.no.see.model.beans.User;

public class Result_user {
	
	private Integer code;
	private User data;
	private List<String> permission;
	
	public List<String> getPermission() {
		return permission;
	}
	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result_user [code=" + code + ", data=" + data + ", permission=" + permission + "]";
	}
}
