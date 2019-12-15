package com.liujy.mycollection;

/**
 * 	自定义LinkedList
 * 	增加小封装、增加泛型
 * @author 刘建阳
 *
 */
public class MyLinkedList05<E> {
	
	private Node first;
	private Node last;
	private int size;
	
	public MyLinkedList05() {
		super();
	}

	public MyLinkedList05(Node first, Node last) {
		super();
		this.first = first;
		this.last = last;
	}
	
	public void add(E element) {
		Node node = new Node(element);
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
	
	public void add(int index, E element) {
		checkRange(index);
		Node newNode = new Node(element);
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			up.next = newNode;
			newNode.previous = up;
			newNode.next = temp;
			temp.previous = newNode;
			size++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkRange(index);
		Node temp = getNode(index);
		return temp!=null?(E)temp.element:null;
	}

	private void checkRange(int index) {
		if (index < 0 || index > size-1) {
			throw new RuntimeException("索引不合法：" + index);
		}
	}
	
	public void remove(int index) {
		checkRange(index);
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
		return temp;
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
		MyLinkedList05<String> mll = new MyLinkedList05<>();
		mll.add("a");
		mll.add("b");
		mll.add("c");
		mll.add("d");
		mll.add("e");
		mll.add("f");
		mll.add("g");
		mll.add("h");
		
		System.out.println(mll);
		mll.add(3,"老刘");
		System.out.println(mll);
		System.out.println(mll.get(2));
		
	}
	

}
