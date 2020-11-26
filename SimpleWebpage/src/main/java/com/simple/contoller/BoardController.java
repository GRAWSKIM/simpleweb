package com.simple.contoller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDTO;
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
	public ModelAndView write(
			@RequestParam(value = "boardkey",required = false) String boardkey,
			ModelAndView mav) throws Exception {
		
		
		if (boardkey!=null) {
			mav.addObject("modify","Y");
			mav.addObject("post",service.getPost(boardkey));
		}
		
		mav.setViewName("/writepost");
		return mav;
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
	
	@RequestMapping(value="/editpost", method= RequestMethod.POST)
	public ModelAndView editpost(
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			@RequestParam("pk") String pk,
			ModelAndView mav) throws Exception {
		Map<String, String> map = new HashMap<String, String>();		
		map.put("pk",pk);
		map.put("title",title);
		map.put("contents",contents);
		
		service.updatePost(map);
		
		mav.setViewName("/writepost");
		mav.addObject("msg","수정되었습니다.");
		
		return mav;
	}
	
	@RequestMapping(value="/readpost")
	public ModelAndView readPost(
			ModelAndView mav,
			HttpSession session,
			@RequestParam("boardKey") String boardKey) throws Exception {
		BoardDTO dto = service.getPost(boardKey);
		mav.addObject("post",dto);
		mav.addObject("comments", service.getComment(boardKey));
		
		if( session.getAttribute("loginid") != null && session.getAttribute("loginid").equals( dto.getCreateUser() ) ) {
			mav.addObject("IsWriter",boardKey);
		}
		mav.setViewName("post");
		
		return mav;		
	}
	
	@ResponseBody
	@RequestMapping(value="addreply",method = RequestMethod.POST)
	public CommentDTO addReply(
			HttpSession session,
			@RequestParam("reply") String reply,
			@RequestParam("boardkey") String boardkey,
			@RequestParam("depth") String depth) throws Exception {
		Map<String, String> map = new HashMap<String, String>();		
		map.put("id",(String)session.getAttribute("loginid"));
		map.put("reply",reply);
		map.put("boardkey",boardkey);
		map.put("depth",depth);
		SimpleDateFormat frmt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();		
		map.put("createDate",frmt1.format(time));
					
		CommentDTO commentdto = null;
		if ( service.addReply(map) > 0 ) {
			commentdto = new CommentDTO();
			commentdto.setreply(reply);
			commentdto.setId((String)session.getAttribute("loginid"));
			commentdto.setCreateDate(frmt1.format(time));
			
			return commentdto;
		}
		
		return commentdto;
	}
}