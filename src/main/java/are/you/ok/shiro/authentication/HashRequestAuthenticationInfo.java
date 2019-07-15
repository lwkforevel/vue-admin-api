package are.you.ok.shiro.authentication;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class HashRequestAuthenticationInfo implements SaltedAuthenticationInfo{

	private PrincipalCollection principals;
	private String credentials;
	private ByteSource publicSalt;
	
	@Override
	public PrincipalCollection getPrincipals() {
		return principals;
	} 

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public ByteSource getCredentialsSalt() {
		return publicSalt;
	}

	public HashRequestAuthenticationInfo(String principal, String credentials, ByteSource credentialSalt,String realName) {
		  this.principals = new SimplePrincipalCollection(principal, realName);
	      this.credentials = credentials;
	      this.publicSalt = credentialSalt;
	}

}
