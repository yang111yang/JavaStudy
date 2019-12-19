package com.liujy.mycollection;

/**
 * 	自定义LinkedList
 * 	新增remove方法，实现LinkedList的元素的删除
 * @author 刘建阳
 *
 */
public class MyLinkedList03 {
	
	private Node first;
	private Node last;
	private int size;
	
	public MyLinkedList03() {
		super();
	}

	public MyLinkedList03(Node first, Node last) {
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
		Node temp = getNode(index);
		return temp.element;
	}
	
	public void remove(int index) {
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			// 删除第一个元素
			if (index == 0) {
				first = down;
			}
			if (index == size - 1) {
				last = up;
			}
			if (up != null) {
				up.next = down;
			}
			if (down != null) {
				down.previous = up;
			}
			size--;
		}
		
	}

	private Node getNode(int index) {
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
		return temp!=null?temp:null;
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
		MyLinkedList03 mll = new MyLinkedList03();
		mll.add("a");
		mll.add("b");
		mll.add("c");
		mll.add("d");
		mll.add("e");
		mll.add("f");
		mll.add("g");
		mll.add("h");
		
		mll.remove(0);
		System.out.println(mll);
		mll.remove(6);
		System.out.println(mll);
		
	}
	

}
