package com.simple.DAO;

import java.util.Map;

public interface MemberDao {
	
	public String login(Map map) throws Exception;
	public String duplicateID(Map map) throws Exception;
	public int signup(Map map) throws Exception;
}
