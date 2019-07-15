package are.you.ok.model.result.user;


import java.util.Arrays;

public class UserInfo {
	private String introduction;
	private String avatar;
	private String name;

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserInfo [introduction=" + introduction + ", avatar=" + avatar + ", name=" + name + "]";
	}

	public UserInfo(String introduction, String avatar, String name) {
		super();
		this.introduction = introduction;
		this.avatar = avatar;
		this.name = name;
	}

}
