package com.simple.DAO;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@Override
	public String login(Map map) throws Exception {
		// TODO Auto-generated method stub
		return sqlsessiontemplate.selectOne("login", map);
	}

}
