package com.liujy.mycollection;

/**
 *	ʵ���Զ���ArrayList
 *	���remove����
 * @author ������
 *
 */
public class MyArrayList05<E> {
	
	/* Ĭ�����鳤�� */
	private static final int DEFAULT_CAPACITY = 10;
	/* �������� */
	private Object[] elementData;
	/* �������鳤�� */
	private int size;
	
	// �����޲ι��췽��
	public MyArrayList05() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// �����вι���
	public MyArrayList05(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("����"+capacity+"����Ϊ��");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
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
		// index�߽��ж�
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
	
	public void remove(E element) {
		for (int i = 0; i < elementData.length; i++) {
			if (element.equals(elementData[i])) {
				remove(i);
			}
		}
	}
	
	public void remove(int index) {
		checkRange(index);
		int moveNum = elementData.length - index - 1;
		if (moveNum > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, moveNum);
		}
		elementData[--size] = null;
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
		MyArrayList05<String> mal = new MyArrayList05<>();
		for (int i = 0; i < 40; i++) {
			mal.add("�׹Ǿ�" + i);
		}		
		mal.set("aaaa", 10);
		System.out.println(mal.get(10));
		System.out.println(mal);
		
		mal.remove(3);
		System.out.println(mal);
		
	}

}
