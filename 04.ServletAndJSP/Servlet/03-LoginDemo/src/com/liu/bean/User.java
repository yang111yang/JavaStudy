package com.liu.bean;
/**
 * 用户表实体类
 * @author liujy
 *
 */
public class User {
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String uname;
	/**
	 * 用户密码
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
