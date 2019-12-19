package com.liujy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 	测试使用容器存储表格数据
 * 	ORM思想的简单实验：map表示一行数据，多个map表示多行数据，将多个map放到list中
 * @author 刘建阳
 *
 */
public class TestStoreData {

	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("ID", 1001);
		row1.put("姓名", "张三");
		row1.put("薪水", 20000);
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("ID", 1002);
		row2.put("姓名", "李四");
		row2.put("薪水", 2000);
		
		Map<String, Object> row3 = new HashMap<>();
		row3.put("ID", 1003);
		row3.put("姓名", "王五");
		row3.put("薪水", 30000);
		
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
