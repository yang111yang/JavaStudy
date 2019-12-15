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
 * 	����ʹ��Iterator����List��Set��Map
 * @author ������
 *
 */
public class TestIterator {
	/**
	 * 	ʹ��Iterator����List
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
	 *	ʹ��Iterator����Set
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
	 * 	ʹ��Iterator����Map
	 */
	@Test
	public void testIteratorMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "������");
		map.put(200, "ɳ����");
		map.put(300, "�׹Ǿ�");
		
		// ��һ�ֱ�����ʽ
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for (Iterator<Entry<Integer,String>> iterator = entrySet.iterator();iterator.hasNext();) {
			Entry<Integer,String> entry = iterator.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		System.out.println("+++++++++++++++++");
		
		// �ڶ��ֱ�����ʽ
		Set<Integer> keySet = map.keySet();
		for (Iterator<Integer> iterator = keySet.iterator();iterator.hasNext();) {
			Integer key = iterator.next();
			System.out.println(key + "---" + map.get(key));
		}
	}
}
