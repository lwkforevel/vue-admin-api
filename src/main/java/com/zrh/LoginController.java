package com.zrh;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	  private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	  private String algorithmName = "md5";
	  private final int hashIterations = 2;
	
	@RequestMapping("regist")
	public String login(User user) {
		
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
        UserService userService = null;
        userService.regist(user);
		return "regist";
	}

	
}
