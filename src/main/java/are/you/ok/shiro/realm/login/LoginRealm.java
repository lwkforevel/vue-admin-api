package are.you.ok.shiro.realm.login;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import time.no.see.mapper.user.Sys_UserMapper;
import time.no.see.model.beans.user.Sys_User;

public class LoginRealm extends AuthenticatingRealm{
	
	@Autowired
	private Sys_UserMapper sys_UserMapper;
	/**
     * Constructor that takes in an account's identifying principal(s), hashed credentials used to verify the
     * principals, and the salt used when hashing the credentials.
     *
     * @param principals        a Realm's account's identifying principal(s)
     * @param hashedCredentials the hashed credentials that verify the principals.
     * @param credentialsSalt   the salt used when hashing the hashedCredentials.
     * @see org.apache.shiro.authc.credential.HashedCredentialsMatcher HashedCredentialsMatcher
     * @since 1.1
     ***/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		char[] password = usernamePasswordToken.getPassword();
		Sys_User sys_user = sys_UserMapper.getSys_UserByUsername(username);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(password,sys_user.getPassword(),ByteSource.Util.bytes(sys_user.getSalt()),getName());
		return simpleAuthenticationInfo;
	}


}
