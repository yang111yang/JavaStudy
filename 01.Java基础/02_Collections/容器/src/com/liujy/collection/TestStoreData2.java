package com.liujy.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 	测试使用Javabean存储表格数据
 * 	体会ORM思想
 * @author 刘建阳
 *
 */
public class TestStoreData2 {
	
	public static void main(String[] args) {
		User user1 = new User(1001, "张三", 20000);
		User user2 = new User(1002, "李四", 2000);
		User user3 = new User(1003, "王五", 30000);
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		for (User user : list) {
			System.out.println(user);
		}
		
		
	}

}

class User{
	private int id;
	private String name;
	private double salary;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",salary:"+salary;
	}
}