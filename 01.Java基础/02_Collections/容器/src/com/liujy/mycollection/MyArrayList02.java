package com.liujy.mycollection;

/**
 *	ʵ���Զ���ArrayList
 *	��ӷ���
 * @author ������
 *
 */
public class MyArrayList02<E> {
	
	/* Ĭ�����鳤�� */
	private static final int DEFAULT_CAPACITY = 10;
	/* �������� */
	private Object[] elementData;
	/* �������鳤�� */
	private int size;
	
	// �����޲ι��췽��
	public MyArrayList02() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// �����вι���
	public MyArrayList02(int capacity) {
		elementData = new Object[capacity];
	}
	
	/**
	 * 	���Ԫ��
	 * @param obj
	 */
	public void add(E element) {
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
		MyArrayList02<String> mal = new MyArrayList02<>();
		mal.add("aa");
		mal.add("bb");
		mal.add("cc");
		
		System.out.println(mal);
		
	}

}
