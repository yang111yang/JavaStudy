package com.liujy.collection;

import java.util.Map;
import java.util.TreeMap;
 
/**
 * 	测试TreeMap的使用
 * 	TreeMap主要使用场景是排序
 * @author 刘建阳
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		// 以key为Integer类型进行排序
		Map<Integer,String> treeMap1 = new TreeMap<>();
		treeMap1.put(10,"aa");
		treeMap1.put(50,"bb");
		treeMap1.put(30,"cc");
		treeMap1.put(100,"dd");
		
		for (Integer key : treeMap1.keySet()) {
			System.out.println(key + "-----" + treeMap1.get(key));
		}
		
		// key为引用类型排序
		Map<Emp,String> treeMap2 = new TreeMap<>();
		treeMap2.put(new Emp(100, "张三", 50000),"张三是个好领导");
		treeMap2.put(new Emp(50, "李四", 5000),"李四工作不努力");
		treeMap2.put(new Emp(1000, "赵六", 6000),"赵六工作很努力");
		treeMap2.put(new Emp(300, "王五", 6000),"王五工作还不错");
		
		for (Emp key : treeMap2.keySet()) {
			System.out.println(key + "-----" + treeMap2.get(key));
		}
	}
	
}


class Emp implements Comparable<Emp>{
	int id;
	String name;
	double salary;
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ",salary:" + salary + ",name:" + name;
	}
	
	@Override
	public int compareTo(Emp o) { // 负数：小于，0：等于，正数：大于
		if (this.salary < o.salary) {
			return -1;
		} else if (this.salary > o.salary) {
			return 1;
		} else {
			if (this.id < o.id) {
				return -1;
			} else if (this.id > o.id) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}