package com.simple.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInUpController {

	@RequestMapping("/")
	public String Login() {
		return "/signin";
	}
}
