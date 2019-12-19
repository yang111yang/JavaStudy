package com.liujy.file;

import java.io.File;
import java.io.IOException;

/**
 * 	判断状态
 * 	exists()	判断文件或者目录是否存在
 * 	isFile()	判断是否为文件
 * 	isDirectory()	判断是否为目录
 * @author 刘建阳
 *
 */
public class FileDemo03 {

	public static void main(String[] args) throws IOException {
		File file = new File("E:/workspace/SXT/IO流/io.jpg");
		boolean flag = file.exists();
		System.out.println(flag);
		
		// 判断状态的标准代码
		if (!file.exists()) {
			System.out.println("文件不存在，创建文件成功");
		} else {
			if (file.isFile()) {
				System.out.println("该文件对象是个文件");
			} else {
				System.out.println("该文件对象是个目录");
			}
		}
		
	}

}
