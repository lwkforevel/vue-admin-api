package are.you.ok.shiro.matcher;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.ByteSource;

public class DeconstructUtil {
	
	public  <T> T deconstructInfo (Object info,String name){
		//’À∫≈¥”token÷–»°
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
			credentialSalt = saltedAuthenticationInfo.getCredentials();
		}
		switch (name) {
		case "username":
			ByteSource bytes = ByteSource.Util.bytes(username);
			t = (T) bytes;
			break;
		case "password":
			t = (T) password;
			break;
		case "credential":
			t = (T) credential;
			break;
		case "credentialSalt":
			t = (T) credentialSalt;
			break;
					}
		return t;
	}
}
