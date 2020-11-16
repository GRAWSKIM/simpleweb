package com.simple.DAO;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDto;
import com.simple.DTO.PostDto;

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
	public PostDto getPost(String postKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDto getComment(String postKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
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




}
