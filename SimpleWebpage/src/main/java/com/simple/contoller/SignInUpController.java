package com.simple.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simple.Service.MemberService;

@Controller
public class SignInUpController {
	
	@Autowired
	MemberService service;

	@RequestMapping("/")
	public String gotologin() {
		return "/signin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView Login(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			ModelAndView mav,
			HttpSession session ) throws Exception {
		
		if(service.login(id, password)==false) {
			mav.addObject("msg", "로그인 실패했습니다.");
			mav.setViewName("/signin");			
		}else {
			mav.setViewName("/home");
		}
						
		return mav;
	}
	
}
