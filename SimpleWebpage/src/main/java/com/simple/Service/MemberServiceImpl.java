package com.simple.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.DAO.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean login(String id, String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id);
		map.put("password",password);
		
		String loginResult;
		loginResult = dao.login(map);
		
		if ( loginResult == null ||  loginResult.length() == 0 || loginResult.equals("0") ) return false;
		
		if ( Integer.parseInt(loginResult) > 0) return true;
		
		return false;
	}

	@Override
	public String signup(String id, String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id);
		map.put("password",password);
		
		String checkDuplicate = dao.duplicateID(map);
		if(!checkDuplicate.equals("0")) {
			return "이미 있는 ID";
		}
		
		int result = dao.signup(map);
		
		if(result==1) {
			return "OK";
		}else {
			return "ID 생성에 실패했습니다.";
		}		
		
	}

}
