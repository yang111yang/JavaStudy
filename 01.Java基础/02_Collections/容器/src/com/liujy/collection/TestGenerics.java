package com.liujy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	≤‚ ‘∑∫–Õ
 * @author ¡ıΩ®—Ù
 *
 */
public class TestGenerics {
	
	public static void main(String[] args) {
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("¡ıΩ®—Ù", 0);
		
		String a = mc.get(0);
		System.out.println(a);
		
		List list = new ArrayList();
		Map map = new HashMap();
	}
	
	
}

class MyCollection <E> {
	Object[] objs = new Object[5];
	
	public void set(E e, int index) {
		objs[index] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) objs[index];
	}
}
