package com.simple.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.simple.DAO.MemberDao;

public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean login(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		return dao.login();
	}

}
