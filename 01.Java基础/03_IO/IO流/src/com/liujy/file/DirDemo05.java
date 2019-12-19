package com.liujy.file;

import java.io.File;

/**
 * 	递归
 * 	获取文件夹的大小
 * @author 刘建阳
 *
 */
public class DirDemo05 {
	
	public static void main(String[] args) {
		File src = new File("E:/workspace/SXT/IO流/");
		count(src);
		System.out.println(len);
	}
	public static long len;
	public static void count(File file) {
		// 获取文件夹的大小
		if (file != null && file.exists()) { // 递归头
			if (file.isFile()) {
				len += file.length();
			} else {
				File[] files = file.listFiles();
				for (File f : files) {
					count(f); // 递归体
				}
			}
		} 
	}

}
