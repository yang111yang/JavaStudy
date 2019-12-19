package com.liujy.mycollection;

/**
 *	ʵ���Զ���ArrayList
 * @author ������
 *
 */
public class MyArrayList01 {
	
	/* Ĭ�����鳤�� */
	private static final int DEFAULT_CAPACITY = 10;
	/* �������� */
	private Object[] elementData;
	/* �������鳤�� */
	private int size;
	
	// �����޲ι��췽��
	public MyArrayList01() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// �����вι���
	public MyArrayList01(int capacity) {
		elementData = new Object[capacity];
	}
	
	/**
	 * 	���Ԫ��
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
