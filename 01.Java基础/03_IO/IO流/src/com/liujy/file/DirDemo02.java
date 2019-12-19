package com.liujy.file;

import java.io.File;

/**
 * 	查看目录中的元素
 * @author 刘建阳
 *
 */
public class DirDemo02 {
	
	public static void main(String[] args) {
		// list()
		File dir = new File("E:/workspace/SXT/IO流/");
		String[] list = dir.list();
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("==================");
		
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			
			System.out.println(file.getAbsolutePath());
		}
		
		File[] listRoots = dir.listRoots(); // 查看盘符
		for (File file : listRoots) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
