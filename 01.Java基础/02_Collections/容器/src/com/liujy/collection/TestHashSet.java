package com.liujy.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * ����HashSet
 * Set:û��˳�򣬲����ظ�
 * List:��˳�򣬿��ظ�
 * @author ������
 *
 */
public class TestHashSet {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("aa");
		System.out.println(set);
		/*
		 * HashSetʵ���Ͼ���һ��HashMap��ֻ�����ǰ�HashSet�е�Ԫ�ش���
		 * ��HashMap�е�key���ˣ������뿴HashSetԴ��
		 */
	}

}
