package com.liujy.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 	����Map�еĳ��÷���
 * @author ������
 *
 */
public class TestMap2 {
	
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "������", 6000);
		Employee e2 = new Employee(1002, "����", 10000);
		Employee e3 = new Employee(1003, "����", 50000);
		
		Map<Integer,Employee> map = new HashMap<>();
		map.put(1001,e1);
		map.put(1002,e2);
		map.put(1003,e3);
		
		Employee employee = map.get(1001);
		System.out.println(employee.getEname());
		System.out.println(map);
	}

}

class Employee {
	private int id;
	private String ename;
	private double salary;
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
		public String toString() {
			return "id:"+id+" ������"+ename+" нˮ��"+salary;
		}
}
