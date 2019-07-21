package are.you.ok.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

public class HashRequestMatcher implements CredentialsMatcher{
	
/*	<property name="hashAlgorithmName" value="MD5"></property>
	<!-- 加密次数 -->
	<property name="hashIterations" value="2"></property>*/
	
	private DefaultHashService defaultHashService;
	
	private String getTokenCredential(AuthenticationToken token,AuthenticationInfo info) throws InstantiationException, IllegalAccessException {
		ByteSource credentialSalt = deconstructInfo(info,"credentialSalt");
		ByteSource password = deconstructInfo(token,"password");
		ByteSource username = deconstructInfo(token,"username");
		defaultHashService.setPrivateSalt(username);
		HashRequest request = new HashRequest.Builder()
				 .setSource(password)
	             .setSalt(credentialSalt).build();
		String hex = defaultHashService.computeHash(request).toHex();
		return hex;
	}

	
	private String getInfoCredential(AuthenticationInfo info) throws InstantiationException, IllegalAccessException {
		String credential = deconstructInfo(info,"credential");
		return credential;
	}
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		boolean equals = false;
		try {
			String tokenCredential = getTokenCredential(token, info);
			String infoCredential = getInfoCredential(info);
			equals = tokenCredential.equals(infoCredential);
		} catch (Exception e) {
		}
		return equals;
	}


	public DefaultHashService getDefaultHashService() {
		return defaultHashService;
	}


	public void setDefaultHashService(DefaultHashService defaultHashService) {
		this.defaultHashService = defaultHashService;
	}


	@Override
	public String toString() {
		return "HashRequestMatcher [defaultHashService=" + defaultHashService + "]";
	}

	public  <T> T deconstructInfo (Object info,String name) throws InstantiationException, IllegalAccessException{
		//账号从token中取
		T t = null;
		String username = null;
		char[] password = null;
		Object credential = null;
		Object credentialSalt = null;
		if(info instanceof UsernamePasswordToken) {
			UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)info;
			username = usernamePasswordToken.getUsername();
			password = usernamePasswordToken.getPassword();
		}
		if(info instanceof SaltedAuthenticationInfo) {
			SaltedAuthenticationInfo saltedAuthenticationInfo = (SaltedAuthenticationInfo)info;
			credential = saltedAuthenticationInfo.getCredentials();
			credentialSalt = saltedAuthenticationInfo.getCredentialsSalt();
		}
		switch (name) {
		case "username":
			ByteSource byteUsername = ByteSource.Util.bytes(username);
			t = (T) byteUsername;
			break;
		case "password":
			ByteSource bytePassword = ByteSource.Util.bytes(password);
			t = (T) bytePassword;
			break;
		case "credential":
			t = (T) credential;
			break;
		case "credentialSalt":
			ByteSource byteCredentialSalt = ByteSource.Util.bytes(credentialSalt);
			t = (T) byteCredentialSalt;
			break;
					}
		return t;
	}
}
