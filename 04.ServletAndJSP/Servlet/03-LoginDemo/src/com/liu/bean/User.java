package com.liu.bean;
/**
 * �û���ʵ����
 * @author liujy
 *
 */
public class User {
	/**
	 * �û�id
	 */
	private int id;
	/**
	 * �û���
	 */
	private String uname;
	/**
	 * �û�����
	 */
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(int id, String uname, String pwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
	}
	
	public User() {
	}
}
