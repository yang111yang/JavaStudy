package com.liujy.mycollection;

public class Node {
	
	Node previous;
	Node next;
	Object element;
	
	public Node(Object obj) {
		super();
		this.element = obj;
	}

	public Node(Node previous, Node next, Object obj) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = obj;
	}
	
	

}
