package com.simple.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CertificationInteceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();		
		String id = (String)session.getAttribute("loginid");

		String requestUrl = request.getRequestURL().toString();
				
		if( id == null || id.equals("") ) {
			response.sendRedirect("/");
			return false;
		}else 
		{
			//session.setMaxInactiveInterval(30*60);
			return true;
		}
		
	}
	
}
