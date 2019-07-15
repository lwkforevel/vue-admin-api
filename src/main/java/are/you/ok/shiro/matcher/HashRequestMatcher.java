package are.you.ok.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class HashRequestMatcher implements CredentialsMatcher{
	
/*	<property name="hashAlgorithmName" value="MD5"></property>
	<!-- ¼ÓÃÜ´ÎÊý -->
	<property name="hashIterations" value="2"></property>*/
	private String hashAlgorithmName;
	
	private Integer hashIterations;
	
	
	
	
	
	private String getTokenCredential(AuthenticationToken token,AuthenticationInfo info) {
		Object credentials = token.getCredentials();
		Object principal = token.getPrincipal();
		Object salt = null;
		if(info instanceof SaltedAuthenticationInfo) {
			salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
		}
		DefaultHashService defaultHashService = new DefaultHashService();
		defaultHashService.setPrivateSalt(ByteSource.Util.bytes(principal));
		defaultHashService.setHashAlgorithmName(getHashAlgorithmName());
		HashRequest request = new HashRequest.Builder()
	             .setSource(ByteSource.Util.bytes(credentials))
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
