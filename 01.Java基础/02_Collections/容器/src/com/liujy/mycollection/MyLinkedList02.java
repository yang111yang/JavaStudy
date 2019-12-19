package com.liujy.mycollection;

/**
 * 	自定义LinkedList
 * 	新增get方法，实现LinkedList的简单遍历
 * @author 刘建阳
 *
 */
public class MyLinkedList02 {
	
	private Node first;
	private Node last;
	private int size;
	
	public MyLinkedList02() {
		super();
	}

	public MyLinkedList02(Node first, Node last) {
		super();
		this.first = first;
		this.last = last;
	}
	
	public void add(Object obj) {
		Node node = new Node(obj);
		if (first == null) {
			first = node;
			last = node;
		} else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
		size++;
	}
	
	public Object get(int index) {
		if (index < 0 || index > size-1) {
			throw new RuntimeException("索引不合法：" + index);
		}
		Node temp = null;
		if (index <= (size >> 1)) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for (int i = size - 1; i > index; i--) {
				temp = temp.previous;
			}
		}
		return temp.element;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while (temp != null) {
			sb.append(temp.element + ",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyLinkedList02 mll = new MyLinkedList02();
		mll.add("a");
		mll.add("b");
		mll.add("c");
		mll.add("d");
		mll.add("e");
		mll.add("f");
		mll.add("g");
		mll.add("h");
		System.out.println(mll);
		
		System.out.println(mll.get(1));
	}
	

}
