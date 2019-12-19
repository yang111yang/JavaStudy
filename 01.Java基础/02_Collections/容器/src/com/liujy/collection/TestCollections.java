package com.liujy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	测试Collections工具类的使用 
 * @author 刘建阳
 *
 */
public class TestCollections {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("zbj" + i);
		}
		
		System.out.println(list);
		
		Collections.shuffle(list); // 随机排列list中的元素
		System.out.println(list);
		
		Collections.reverse(list); // 逆序排列list中的元素
		System.out.println(list);
		
		Collections.sort(list);	// 递增排列list中的元素
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "zbj1"));  // 二分查找或对半查找
		
		
	}

}
