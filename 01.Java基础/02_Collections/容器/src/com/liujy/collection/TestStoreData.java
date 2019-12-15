package com.liujy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 	����ʹ�������洢�������
 * 	ORM˼��ļ�ʵ�飺map��ʾһ�����ݣ����map��ʾ�������ݣ������map�ŵ�list��
 * @author ������
 *
 */
public class TestStoreData {

	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("ID", 1001);
		row1.put("����", "����");
		row1.put("нˮ", 20000);
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("ID", 1002);
		row2.put("����", "����");
		row2.put("нˮ", 2000);
		
		Map<String, Object> row3 = new HashMap<>();
		row3.put("ID", 1003);
		row3.put("����", "����");
		row3.put("нˮ", 30000);
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		for (Map<String, Object> row : list) {
			Set<String> keySet = row.keySet();
			for (String key : keySet) {
				System.out.print(key+":"+row.get(key)+"    ");
			}
			System.out.println();
		}
		
	}
	
}
