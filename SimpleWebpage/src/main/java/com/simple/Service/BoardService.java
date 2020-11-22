package com.simple.Service;

import java.util.List;
import java.util.Map;
import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDTO;

public interface BoardService {

	public List<BoardDTO> getBoradList(String pageNo,String where) throws Exception;
	public int getPageNo(String where) throws Exception;
	
	public BoardDTO getPost(String postKey) throws Exception;
	public CommentDTO getComment(String postKey) throws Exception;
	public int addReply(Map<String,String> map) throws Exception;
		
	public int writePost(Map<String,String> map) throws Exception;
}
