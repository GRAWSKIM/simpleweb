package com.simple.Service;


public interface MemberService {
	
	public boolean login(String id, String password) throws Exception;
	public void logout() throws Exception;
	public String signup(String id, String password) throws Exception;
	
}
