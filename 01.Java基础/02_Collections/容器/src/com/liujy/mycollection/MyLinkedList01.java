package com.liujy.mycollection;

/**
 * 	自定义LinkedList
 * @author 刘建阳
 *
 */
public class MyLinkedList01 {
	
	private Node first;
	private Node last;
	private int size;
	
	public MyLinkedList01() {
		super();
	}

	public MyLinkedList01(Node first, Node last) {
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
		MyLinkedList01 mll = new MyLinkedList01();
		mll.add("a");
		mll.add("b");
		mll.add("c");
		mll.add("d");
		mll.add("e");
		mll.add("f");
		mll.add("g");
		mll.add("h");
		System.out.println(mll);
		
	}
	

}
