package com.liujy.file;

import java.io.File;

/**
 * 	�鿴Ŀ¼�е�Ԫ��
 * @author ������
 *
 */
public class DirDemo02 {
	
	public static void main(String[] args) {
		// list()
		File dir = new File("E:/workspace/SXT/IO��/");
		String[] list = dir.list();
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("==================");
		
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			
			System.out.println(file.getAbsolutePath());
		}
		
		File[] listRoots = dir.listRoots(); // �鿴�̷�
		for (File file : listRoots) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
