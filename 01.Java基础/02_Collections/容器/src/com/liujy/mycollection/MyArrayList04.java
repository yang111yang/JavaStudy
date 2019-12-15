package com.liujy.mycollection;

/**
 *	实现自定义ArrayList
 *	添加get和set方法，并实现下标判断
 * @author 刘建阳
 *
 */
public class MyArrayList04<E> {
	
	/* 默认数组长度 */
	private static final int DEFAULT_CAPACITY = 10;
	/* 定义数组 */
	private Object[] elementData;
	/* 定义数组长度 */
	private int size;
	
	// 定义无参构造方法
	public MyArrayList04() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// 定义有参构造
	public MyArrayList04(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("容量"+capacity+"不能为负");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
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
	
	public void set(E element, int index) {
		checkRange(index);
		elementData[index] = element;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkRange(index);
		return (E) elementData[index];
	}

	private void checkRange(int index) {
		// index边界判断
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
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
		MyArrayList04<String> mal = new MyArrayList04<>();
		for (int i = 0; i < 40; i++) {
			mal.add("白骨精" + i);
		}		
		mal.set("aaaa", 10);
		System.out.println(mal.get(10));
		System.out.println(mal);
		
	}

}
