package com.simple.DAO;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDTO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@Override
	public List<BoardDTO> getBoradList(Map<String, String> map) throws Exception {
		return sqlsessiontemplate.selectList("getBoardList",map);
	}
	
	@Override
	public int getPageNo(String where) throws Exception {
		return sqlsessiontemplate.selectOne("getPageNo",where);
	}

	@Override
	public BoardDTO getPost(String postKey) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.selectOne("getPost",postKey);
	}

	@Override
	public List<CommentDTO> getComment(String boardKey) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.selectList("getComments",boardKey);
	}

	@Override
	public int writePost(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.insert("writePost",map);
	}

	@Override
	public int writetBoard(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.insert("writeBoard",map);
	}

	@Override
	public String getSequence(String name) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.selectOne("getSequence", name);
	}

	@Override
	public int setSequence(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.update("setSequence", map);
	}

	@Override
	public int addReply(Map<String, String> map) throws Exception {
		return sqlsessiontemplate.insert("addReply", map);
	}

	@Override
	public int updatePost(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.update("updatePost", map);
	}




}
