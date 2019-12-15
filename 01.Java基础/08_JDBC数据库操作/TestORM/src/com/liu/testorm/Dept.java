package com.liu.testorm;

/**
 * 部门类
 * @author liujy
 *
 */
public class Dept {

	private Integer id;
	private String deptname;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Dept(Integer id, String deptname, String address) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.address = address;
	}
	public Dept(String deptname, String address) {
		super();
		this.deptname = deptname;
		this.address = address;
	}
	
	public Dept() {
	}
	
	
}
