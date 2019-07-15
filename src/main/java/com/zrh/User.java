package com.zrh;

public class User {
	
	private String username;
	private String password;
	private String salt;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", salt=" + salt + "]";
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCredentialsSalt() {
		String credentialsSalt = this.username+this.salt;
		return credentialsSalt;
	}
	
}
