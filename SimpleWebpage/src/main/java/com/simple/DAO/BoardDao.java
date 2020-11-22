package com.simple.DAO;

import java.util.List;
import java.util.Map;

import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDTO;

public interface BoardDao {

	public List<BoardDTO> getBoradList(Map<String, String> map) throws Exception;
	public int getPageNo(String where) throws Exception;
	public BoardDTO getPost(String postKey) throws Exception;
	public CommentDTO getComment(String postKey) throws Exception;
	public int addReply(Map<String, String> map) throws Exception;
	
	public int writePost(Map<String, String> map) throws Exception;
	public int writetBoard(Map<String, String> map) throws Exception;
	
	public String getSequence(String name) throws Exception;
	public int setSequence(Map<String, String> map) throws Exception;
}
