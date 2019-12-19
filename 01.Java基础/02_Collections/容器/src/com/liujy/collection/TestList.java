package com.liujy.collection;

import java.util.*;

/**
 * 	²âÊÔCollectionÖĞµÄ³£ÓÃ·½·¨
 * @author Áõ½¨Ñô
 *
 */
public class TestList {

	public static void main(String[] args) {
		test03();
	}

	public static void test01() {
		Collection<String> c = new ArrayList<>();
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		c.add("ËïÎò¿Õ");
		c.add("É³ºÍÉĞ");
		Object[] arrays = c.toArray();
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
		System.out.println();
		System.out.println(c);
		
		c.remove("É³ºÍÉĞ");
		System.out.println(c);
		
		System.out.println(c.contains("ËïÎò¿Õ"));
		
		c.add("ÌÆÈı²Ø");
		c.add("Öí°Ë½ä");
		
		Iterator<String> iterator = c.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
			
		}
		
		c.clear();
		System.out.println(c);
	}
	
	public static void test02() {
		List<String> list01 = new ArrayList<String>();
		list01.add("a");
		list01.add("b");
		list01.add("c");
		list01.add("d");
		
		List<String> list02 = new ArrayList<String>();
		list02.add("c");
		list02.add("d");
		list02.add("e");
		list02.add("f");
		
		System.out.println("list01:"+list01);
		
//		list01.addAll(list02);
		System.out.println(list01.containsAll(list02));
		list01.retainAll(list02);
		System.out.println("list01:"+list01);
		
		
		
	}

	public static void test03() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(list);
		
		list.add(1, "Öí°Ë½ä");
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		
		list.set(1, "É³ºÍÉĞ");
		System.out.println(list);
		
		System.out.println(list.get(1));
		
		list.add("D");
		list.add("C");
		list.add("B");
		list.add("A");
		
		System.out.println(list);
		
		System.out.println(list.indexOf("C"));
		System.out.println(list.lastIndexOf("C"));
		
	}
	
	
}
