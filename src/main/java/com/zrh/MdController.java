package com.zrh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MdController {

	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		
		return "unauthorized";
	}
	
	
	@RequestMapping("/success")
	public String success() {
		
		return "success";
	}
	
	
}
