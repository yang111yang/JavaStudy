package com.liu.testorm;

/**
 * 雇员类
 * @author liujy
 *
 */
public class Emp {

	private Integer id;
	private String empname;
	private Double salary;
	private Integer age;
	private Integer deptId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	public Emp(Integer id, String empname, Double salary, Integer age, Integer deptId) {
		super();
		this.id = id;
		this.empname = empname;
		this.salary = salary;
		this.age = age;
		this.deptId = deptId;
	}
	public Emp(String empname, Double salary, Integer age, Integer deptId) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
		this.deptId = deptId;
	}
	public Emp(String empname, Double salary, Integer age) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
	}
	
	public Emp() {
	}
	
	
}
