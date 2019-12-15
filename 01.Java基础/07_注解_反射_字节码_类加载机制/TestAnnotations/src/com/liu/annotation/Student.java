package com.liu.annotation;

@Table("tb_student")
public class Student {
	
	@StudentFiled(columnName = "id", type = "int", len = 10)
	private int id;
	@StudentFiled(columnName = "sname", type = "varchar", len = 10)
	private String sname;
	@StudentFiled(columnName = "age", type = "int", len = 3)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
