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
		return sqlsessiontemplate.selectOne("login", map);
	}

	@Override
	public int signup(Map map) throws Exception {
		return sqlsessiontemplate.insert("signup", map);
	}

	@Override
	public String duplicateID(Map map) throws Exception {
		return sqlsessiontemplate.selectOne("checkDuplicateID", map);
	}

}
