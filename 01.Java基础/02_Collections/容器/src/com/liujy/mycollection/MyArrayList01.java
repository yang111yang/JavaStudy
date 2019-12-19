package com.liujy.mycollection;

/**
 *	实现自定义ArrayList
 * @author 刘建阳
 *
 */
public class MyArrayList01 {
	
	/* 默认数组长度 */
	private static final int DEFAULT_CAPACITY = 10;
	/* 定义数组 */
	private Object[] elementData;
	/* 定义数组长度 */
	private int size;
	
	// 定义无参构造方法
	public MyArrayList01() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// 定义有参构造
	public MyArrayList01(int capacity) {
		elementData = new Object[capacity];
	}
	
	/**
	 * 	添加元素
	 * @param obj
	 */
	public void add(Object obj) {
		elementData[size++] = obj;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i] + ",");
		}
		sb.setCharAt(sb.length()-1, ']');

		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyArrayList01 mal = new MyArrayList01();
		mal.add("aa");
		mal.add("bb");
		mal.add("cc");
		
		System.out.println(mal);
		
	}

}
