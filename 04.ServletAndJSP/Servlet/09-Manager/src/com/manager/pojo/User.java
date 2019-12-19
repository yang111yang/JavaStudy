package com.manager.pojo;
/**
 * 用户表实体类
 * @author liujy
 *
 */
public class User {
	/** 用户id */
	private int uid;
	/** 用户名 */
	private String uname;
	/** 用户密码 */
	private String pwd;
	/** 性别 */
	private String sex;
	/** 年龄 */
	private int age;
	/** 生日 */
	private String birth;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", sex=" + sex + ", age=" + age + ", birth="
				+ birth + "]";
	}
	public User(int uid, String uname, String pwd, String sex, int age, String birth) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
		this.birth = birth;
	}
	public User() {
		
	}
	
	
	
}
