package com.liujy.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * 	����TreeSet��ʹ��
 * 	TreeSet�ĵײ�ʵ���Ͼ���һ��TreeMap��ʵ���Ͼ��ǰ�Ԫ�ش洢��TreeMap��key��
 * @author ������
 *
 */
public class TestTreeSet{
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(100);
		set.add(30);
		set.add(600);
		for (Integer value : set) {
			System.out.println(value);
		}
		
		Set<Emp> set1 = new TreeSet<Emp>();
		set1.add(new Emp(100, "����", 2000));
		set1.add(new Emp(300, "����", 4000));
		set1.add(new Emp(50, "����", 1000));
		for (Emp emp : set1) {
			System.out.println(emp);
		}
	}
}