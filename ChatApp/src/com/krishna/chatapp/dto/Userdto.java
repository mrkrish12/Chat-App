package com.krishna.chatapp.dto;

public class Userdto {
    private String userid;
    private char[] password;
    public Userdto(String userid,char[] password) {
    	this.userid = userid;
    	this.password = password;
    }
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
    
}
