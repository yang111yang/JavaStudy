package com.liujy.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet
 * Set:没有顺序，不可重复
 * List:有顺序，可重复
 * @author 刘建阳
 *
 */
public class TestHashSet {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("aa");
		System.out.println(set);
		/*
		 * HashSet实际上就是一个HashMap，只不过是把HashSet中的元素存入
		 * 到HashMap中的key中了，详情请看HashSet源码
		 */
	}

}
