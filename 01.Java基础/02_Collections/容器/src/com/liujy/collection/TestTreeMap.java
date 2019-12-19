package com.liujy.collection;

import java.util.Map;
import java.util.TreeMap;
 
/**
 * 	����TreeMap��ʹ��
 * 	TreeMap��Ҫʹ�ó���������
 * @author ������
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		// ��keyΪInteger���ͽ�������
		Map<Integer,String> treeMap1 = new TreeMap<>();
		treeMap1.put(10,"aa");
		treeMap1.put(50,"bb");
		treeMap1.put(30,"cc");
		treeMap1.put(100,"dd");
		
		for (Integer key : treeMap1.keySet()) {
			System.out.println(key + "-----" + treeMap1.get(key));
		}
		
		// keyΪ������������
		Map<Emp,String> treeMap2 = new TreeMap<>();
		treeMap2.put(new Emp(100, "����", 50000),"�����Ǹ����쵼");
		treeMap2.put(new Emp(50, "����", 5000),"���Ĺ�����Ŭ��");
		treeMap2.put(new Emp(1000, "����", 6000),"����������Ŭ��");
		treeMap2.put(new Emp(300, "����", 6000),"���幤��������");
		
		for (Emp key : treeMap2.keySet()) {
			System.out.println(key + "-----" + treeMap2.get(key));
		}
	}
	
}


class Emp implements Comparable<Emp>{
	int id;
	String name;
	double salary;
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ",salary:" + salary + ",name:" + name;
	}
	
	@Override
	public int compareTo(Emp o) { // ������С�ڣ�0�����ڣ�����������
		if (this.salary < o.salary) {
			return -1;
		} else if (this.salary > o.salary) {
			return 1;
		} else {
			if (this.id < o.id) {
				return -1;
			} else if (this.id > o.id) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}