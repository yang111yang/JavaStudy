package com.liujy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	����Collections�������ʹ�� 
 * @author ������
 *
 */
public class TestCollections {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("zbj" + i);
		}
		
		System.out.println(list);
		
		Collections.shuffle(list); // �������list�е�Ԫ��
		System.out.println(list);
		
		Collections.reverse(list); // ��������list�е�Ԫ��
		System.out.println(list);
		
		Collections.sort(list);	// ��������list�е�Ԫ��
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "zbj1"));  // ���ֲ��һ�԰����
		
		
	}

}
