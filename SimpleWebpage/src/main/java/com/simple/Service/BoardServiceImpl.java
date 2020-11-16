package com.simple.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.DAO.BoardDao;
import com.simple.DTO.BoardDTO;
import com.simple.DTO.CommentDto;
import com.simple.DTO.PostDto;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao dao;

	@Override
	public List<BoardDTO> getBoradList(String pageNo, String where) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		
		if (where!=null) map.put("where", where);
		map.put("pageNo", pageNo);
		
		
		return dao.getBoradList(map);
	}
	@Override
	public int writePost(Map<String, String> map) throws Exception {

		SimpleDateFormat frmt1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		map.put("createDate",frmt1.format(time));
		
		return dao.writetBoard(map);
	}
	
	@Override
	public int getPageNo(String where) throws Exception {
		
		return dao.getPageNo(where);
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

}
