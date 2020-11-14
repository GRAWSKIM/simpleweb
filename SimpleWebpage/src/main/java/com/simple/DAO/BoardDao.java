package com.simple.DAO;

import java.util.List;
import java.util.Map;

import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDto;
import com.simple.DTO.PostDto;

public interface BoardDao {

	public List<BoardDTO> getBoradList(Map<String, String> map) throws Exception;
	public int getPageNo(String where) throws Exception;
	public PostDto getPost(String postKey) throws Exception;
	public CommentDto getComment(String postKey) throws Exception;
	public boolean writePost(String userID) throws Exception;
}
