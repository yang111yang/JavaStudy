package com.liujy.mycollection;

/**
 *	实现自定义ArrayList
 *	添加数组扩容
 * @author 刘建阳
 *
 */
public class MyArrayList03<E> {
	
	/* 默认数组长度 */
	private static final int DEFAULT_CAPACITY = 10;
	/* 定义数组 */
	private Object[] elementData;
	/* 定义数组长度 */
	private int size;
	
	// 定义无参构造方法
	public MyArrayList03() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// 定义有参构造
	public MyArrayList03(int capacity) {
		elementData = new Object[capacity];
	}
	
	/**
	 * 	添加元素
	 * @param obj
	 */
	public void add(E element) {
		// 数组扩容
		if (size == elementData.length) {
			Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
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
		MyArrayList03<String> mal = new MyArrayList03<>();
		for (int i = 0; i < 40; i++) {
			mal.add("白骨精" + i);
		}		
		System.out.println(mal);
		
	}

}
