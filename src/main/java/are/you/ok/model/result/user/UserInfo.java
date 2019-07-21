package are.you.ok.model.result.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class UserInfo {
	
	private List<Map<Integer,Integer>> permission = new ArrayList<Map<Integer,Integer>>();
	private String name;
	private String avatar;
	private String introduction;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public List<Map<Integer, Integer>> getPermission() {
		return permission;
	}
	public void setPermission(String data) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<Integer,Integer>> permission =objectMapper.readValue(data, new TypeReference<List<Map<Integer,Integer>>>() {});
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "UserInfo [roles=" + permission + ", name=" + name + ", avatar=" + avatar + ", introduction=" + introduction
				+ "]";
	}
}
