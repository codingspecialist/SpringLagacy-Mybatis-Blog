package com.spring.board.domain;

public class ReplyVO {
	private int rNum;
	private String rContent;
	private String rWriteDate;
	private int bNum;
	private String userID;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrWriteDate() {
		return rWriteDate;
	}
	public void setrWriteDate(String rWriteDate) {
		this.rWriteDate = rWriteDate;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
}
