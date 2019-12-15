package com.liujy.mycollection;

import java.util.HashMap;

/**
 * 	自定义HashSet
 * @author 刘建阳
 *
 */
public class MyHashSet<K> {
	
	public static final Object PRESENT = new Object();
	HashMap<K,Object> map = null;

	public MyHashSet() {
		map = new HashMap<>();
	}
	
	public void add(K key) {
		map.put(key, PRESENT);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		
		for (K key : map.keySet()) {
			sb.append(key + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyHashSet<String> mhs = new MyHashSet<>();
		mhs.add("aaa");
		mhs.add("bbb");
		mhs.add("ccc");
		mhs.add("ddd");
		System.out.println(mhs);
	}
	
}
