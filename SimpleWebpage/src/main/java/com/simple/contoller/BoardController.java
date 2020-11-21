package com.simple.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
}
/*	board
 *  -pk
 *  -title
 *  -create date
 *  -create user
 */
//select * from ( select * from board order by pk ) where rownum between a-1 and a*5-1; 
//select ceiling(count(1)/5) from board;
//0~4,5~9,10~14
//1~5,6~10,11~15

/* Posts
 * -pk
 * -board_key
 * -contents
 */

/* Comments
 * -pk
 * -post_key
 * -parent_key
 * -depth
 * -idx
 * -create date
 */

//select * from Comments where post_key='board_key' order by idx asc, create date asc, depth asc