package are.you.ok.model.result;

import time.no.see.model.beans.User;

public class Result_user {
	
	private Integer code;
	private User data;
	
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
		return "Result_userinfo [code=" + code + ", data=" + data + "]";
	}
}
