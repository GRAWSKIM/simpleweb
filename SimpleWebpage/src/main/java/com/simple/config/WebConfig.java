package com.simple.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements  WebMvcConfigurer{

	@Autowired
	CertificationInteceptor certificationInteceptor;
	
	@Value("${resources.notload.list}")
	private List<String> notLoadList;	
	
	@Override
 	public void addInterceptors(InterceptorRegistry registry) {	 		 	
		registry.addInterceptor(certificationInteceptor)
				.excludePathPatterns(notLoadList)
				.excludePathPatterns("/")
				.excludePathPatterns("/login")
				.addPathPatterns("/**")				
	        	;       
	   }
}
