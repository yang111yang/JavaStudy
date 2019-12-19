package com.liujy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 	测试使用Iterator遍历List、Set、Map
 * @author 刘建阳
 *
 */
public class TestIterator {
	/**
	 * 	使用Iterator遍历List
	 */
	@Test
	public void testIteratorList() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(Iterator<String> iterator = list.iterator();iterator.hasNext();) {
			String str = iterator.next();
			System.out.println(str);
		}
	}

	/**
	 *	使用Iterator遍历Set
	 */
	@Test
	public void testIteratorSet() {
		Set<String> set = new HashSet<>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		for(Iterator<String> iterator = set.iterator();iterator.hasNext();) {
			String str = iterator.next();
			System.out.println(str);
		}
	}
	
	/**
	 * 	使用Iterator遍历Map
	 */
	@Test
	public void testIteratorMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "唐三藏");
		map.put(200, "沙和尚");
		map.put(300, "白骨精");
		
		// 第一种遍历方式
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for (Iterator<Entry<Integer,String>> iterator = entrySet.iterator();iterator.hasNext();) {
			Entry<Integer,String> entry = iterator.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		System.out.println("+++++++++++++++++");
		
		// 第二种遍历方式
		Set<Integer> keySet = map.keySet();
		for (Iterator<Integer> iterator = keySet.iterator();iterator.hasNext();) {
			Integer key = iterator.next();
			System.out.println(key + "---" + map.get(key));
		}
	}
}
