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
	public String gotologin(HttpSession session) {
		session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
		//session.invalidate();
		return "/signin";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "/signin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView Login(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			ModelAndView mav,
			HttpSession session ) throws Exception {
		
		System.out.println(id+":"+password);
		
		if(service.login(id, password)==false) {
			mav.addObject("msg", "로그인 실패했습니다.");
			mav.setViewName("/signin");			
		}else {
			session.setAttribute("loginid", id);
			mav.setViewName("/home");
		}
						
		return mav;
	}
	
}
