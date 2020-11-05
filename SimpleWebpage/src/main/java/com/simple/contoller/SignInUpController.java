package com.simple.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInUpController {

	@RequestMapping("/")
	public String gotologin() {
		return "/signin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String Login(
			@RequestParam("id") String id,
			@RequestParam("password") String password) {
				
		return "/home";
	}
	
}
