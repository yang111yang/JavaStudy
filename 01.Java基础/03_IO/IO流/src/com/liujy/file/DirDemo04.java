package com.liujy.file;

import java.io.File;

/**
 * 	递归
 * 	获取目录的子孙级目录和文件的名称
 * @author 刘建阳
 *
 */
public class DirDemo04 {
	
	public static void main(String[] args) {
		File src = new File("E:/workspace/SXT/IO流/");
		printFileName(src,0);
	}
	
	public static void printFileName(File file, int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("*");
		}
		// 打印File名
		System.out.println(file.getName());
		
		if (file == null || !file.exists()) { // 递归头
			return;
		} else {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					printFileName(f, deep+1); // 递归体
				}
			}
		}
		
	}

}
