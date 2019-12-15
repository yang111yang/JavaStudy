package com.liujy.file;

import java.io.File;
import java.io.IOException;

/**
 * 	创建文件、删除文件
 * 	createNewFile()		创建文件
 * 	delete()	删除文件
 * @author 刘建阳
 *
 */
public class FileDemo04 {

	public static void main(String[] args) throws IOException {
		File file = new File("E:/workspace/SXT/IO流/io.jpg");
		boolean flag = file.exists();
		System.out.println(flag);
		if (!flag) {
			file.createNewFile();
		}
//		file.delete();
		
		// 补充：con、com3等是操作系统文件名，不能创建文件
		file = new File("con2");
		file.createNewFile();
		file.delete();
	}

}
