package com.liu.vo;

public class User {

	private int uid;
	private String uname;
	private String des;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", des=" + des + "]";
	}
	public User(int uid, String uname, String des) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.des = des;
	}
	public User() {
	}
	
	
	
}
