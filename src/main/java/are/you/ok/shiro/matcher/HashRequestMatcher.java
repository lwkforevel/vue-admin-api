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
	<!-- ¼ÓÃÜ´ÎÊý -->
	<property name="hashIterations" value="2"></property>*/
	private String hashAlgorithmName;
	
	private Integer hashIterations;
	
	private String getTokenCredential(AuthenticationToken token,AuthenticationInfo info) {
		char[] password= null;
		if(token instanceof UsernamePasswordToken) {
			 password = ((UsernamePasswordToken) token).getPassword();
		}
		Object salt = null;
		if(info instanceof SaltedAuthenticationInfo) {
			salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
		}
		DefaultHashService defaultHashService = new DefaultHashService();
		defaultHashService.setPrivateSalt(ByteSource.Util.bytes(token.getPrincipal()));
		defaultHashService.setHashAlgorithmName(getHashAlgorithmName());
		HashRequest request = new HashRequest.Builder()
	             .setSource(ByteSource.Util.bytes(new String(password)))
	             .setSalt(salt).setIterations(getHashIterations()).build();
		String hex = defaultHashService.computeHash(request).toHex();
		return hex;
	}
	
	private String getInfoCredential(AuthenticationInfo info) {
		String credentials = null;
		if(info instanceof SaltedAuthenticationInfo) {
			SaltedAuthenticationInfo saltedAuthenticationInfo = (SaltedAuthenticationInfo) info;
			credentials = (String) saltedAuthenticationInfo.getCredentials();
		}
		return credentials;
	}
	
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String tokenCredential = getTokenCredential(token, info);
		String infoCredential = getInfoCredential(info);
		boolean equals = tokenCredential.equals(infoCredential);
		return equals;
	}


	public String getHashAlgorithmName() {
		return hashAlgorithmName;
	}


	public void setHashAlgorithmName(String hashAlgorithmName) {
		this.hashAlgorithmName = hashAlgorithmName;
	}


	public Integer getHashIterations() {
		return hashIterations;
	}


	public void setHashIterations(Integer hashIterations) {
		this.hashIterations = hashIterations;
	}

	
}
