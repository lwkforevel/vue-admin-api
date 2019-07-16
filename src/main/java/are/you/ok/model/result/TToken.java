package are.you.ok.model.result;

public class TToken {
	
	
	private String privilege;
	
	private String token;

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TToken [privilege=" + privilege + ", token=" + token + "]";
	}
	
	
}
