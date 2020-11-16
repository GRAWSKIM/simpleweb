package com.simple.Service;

import java.util.List;
import java.util.Map;
import com.simple.DTO.BoardDTO;
import com.simple.DTO.PostDto;
import com.simple.DTO.CommentDto;

public interface BoardService {

	public List<BoardDTO> getBoradList(String pageNo,String where) throws Exception;
	public int getPageNo(String where) throws Exception;
	
	public PostDto getPost(String postKey) throws Exception;
	public CommentDto getComment(String postKey) throws Exception;
		
	public int writePost(Map<String,String> map) throws Exception;
}
