package are.you.ok.model.result.user;

import are.you.ok.model.result.BaseResult;

public class Result_UserInfo extends BaseResult<UserInfo>{
	
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Result_UserInfo [userInfo=" + userInfo + "]";
	}
	
}
