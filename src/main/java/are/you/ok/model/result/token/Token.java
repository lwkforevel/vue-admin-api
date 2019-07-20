package are.you.ok.model.result.token;


public class Token{
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Token [username=" + username + "]";
	}
	
	
}
