package com.simple.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simple.Service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board")
	public ModelAndView in(
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "id", required = false) String where,
			ModelAndView mav
			) throws Exception {
		if ( pageNo == null || pageNo.isEmpty() ) pageNo = "1";
		
		mav.addObject("BoardList", service.getBoradList(pageNo,where));
		mav.addObject("pageCount", service.getPageNo(where));
		mav.addObject("pageNo", pageNo);
		
		mav.setViewName("/board");
		return mav;
	}
	
	@RequestMapping("/board/post")
	public String getPost(@RequestParam("postKey") String postKey) {
		
		return "/post";
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam("id") String id) {
				
		return "/writepost";
	}
	
	@RequestMapping(value="/writepost", method = RequestMethod.POST)
	public ModelAndView writepost(
			ModelAndView mav,
			HttpSession session,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents
			) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();		
		map.put("id",(String)session.getAttribute("loginid"));
		map.put("title",title);
		map.put("contents",contents);
		
		service.writePost(map);
		
		mav.setViewName("/writepost");
		mav.addObject("msg","입력완료");
		
		return mav;
	}
	
	@RequestMapping(value="/readpost")
	public ModelAndView readPost(
			ModelAndView mav,
			HttpSession session,
			@RequestParam("boardKey") String boardKey) throws Exception {
		
		mav.addObject("post", service.getPost(boardKey));
		mav.setViewName("post");
		
		return mav;		
	}
	
	@ResponseBody
	@RequestMapping(value="addreply",method = RequestMethod.POST)
	public void addReply(
			HttpSession session,
			@RequestParam("reply") String reply,
			@RequestParam("boardkey") String boardkey,
			@RequestParam("depth") String depth) throws Exception {
		Map<String, String> map = new HashMap<String, String>();		
		map.put("id",(String)session.getAttribute("loginid"));
		map.put("reply",reply);
		map.put("boardKey",boardkey);
		map.put("depth",depth);
		
		service.addReply(map);
	}
}