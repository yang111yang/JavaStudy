package com.liujy.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * 	测试TreeSet的使用
 * 	TreeSet的底层实际上就是一个TreeMap，实际上就是把元素存储到TreeMap的key中
 * @author 刘建阳
 *
 */
public class TestTreeSet{
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(100);
		set.add(30);
		set.add(600);
		for (Integer value : set) {
			System.out.println(value);
		}
		
		Set<Emp> set1 = new TreeSet<Emp>();
		set1.add(new Emp(100, "张三", 2000));
		set1.add(new Emp(300, "李四", 4000));
		set1.add(new Emp(50, "王五", 1000));
		for (Emp emp : set1) {
			System.out.println(emp);
		}
	}
}