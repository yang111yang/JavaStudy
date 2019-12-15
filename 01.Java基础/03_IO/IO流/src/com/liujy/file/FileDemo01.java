package com.liujy.file;

import java.io.File;

/**
 *	 构建文件对象
 * @author 刘建阳
 *
 */
public class FileDemo01 {

	public static void main(String[] args) {
		// 第一种构建方式 File(String parent, String child)
		File file1 = new File("E:/workspace/SXT/IO流", "io.jpg");
		
		// 第二种构建方式 File(File parent, String child)
		File file2 = new File(new File("E:/workspace/SXT/IO流"), "io.jpg");
		
		// 第三种构建方式 File(String name)
		File file3 = new File("io.jpg");
		
		// 第四种构建方式 File(String path)
		File file4 = new File("E:/workspace/SXT/IO流/io.jpg");
		
	}
	
}
