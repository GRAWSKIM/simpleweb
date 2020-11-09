package com.simple.contoller;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	
	@RequestMapping("/board")
	public String gotologin(@RequestParam("id") String id) {
		
		return "/board";
	}
}
