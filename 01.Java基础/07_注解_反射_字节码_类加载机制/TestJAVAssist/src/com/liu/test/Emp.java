package com.liu.test;

public class Emp {

	private int empno;
	private String ename;
	
	public Emp() {
	}

	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}
	
	public void sayHello(int code) {
		System.out.println("say Hi!!!!!");
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	
}
