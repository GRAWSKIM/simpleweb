package com.simple.DTO;

import org.springframework.stereotype.Component;

@Component
public class CommentDTO {

	private String pk;
	private String boardkey;
	private String depth;
	private String comment;
	private String idx;
	private String createDate;
	private String userID;
	
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getBoardkey() {
		return boardkey;
	}
	public void setBoardkey(String boardkey) {
		this.boardkey = boardkey;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
