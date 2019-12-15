package com.liujy.mycollection;

/**
 *	ʵ���Զ���ArrayList
 *	�����������
 * @author ������
 *
 */
public class MyArrayList03<E> {
	
	/* Ĭ�����鳤�� */
	private static final int DEFAULT_CAPACITY = 10;
	/* �������� */
	private Object[] elementData;
	/* �������鳤�� */
	private int size;
	
	// �����޲ι��췽��
	public MyArrayList03() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// �����вι���
	public MyArrayList03(int capacity) {
		elementData = new Object[capacity];
	}
	
	/**
	 * 	���Ԫ��
	 * @param obj
	 */
	public void add(E element) {
		// ��������
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
			mal.add("�׹Ǿ�" + i);
		}		
		System.out.println(mal);
		
	}

}
