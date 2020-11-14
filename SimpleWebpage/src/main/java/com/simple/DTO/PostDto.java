package com.simple.DTO;

import org.springframework.stereotype.Component;

@Component
public class PostDto {

	private String pk;
	private String boardKey;
	private String contents;
	
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getBoardKey() {
		return boardKey;
	}
	public void setBoardKey(String boardKey) {
		this.boardKey = boardKey;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	
}
