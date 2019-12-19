package com.liujy.file;

import java.io.File;

/**
 * 	文件名和路径名相关API
 * 	getName()	获取文件名
 * 	getPath()	获取文件路径，构建文件对象时所用的是什么路径（相对路径或者绝对路径），返回的就是什么路径
 * 	getAbsolutePath()	获取文件的绝对路径
 * 	getParent()		获取文件的父路径（构建文件对象时传入的路径），如果构建文件对象时传入的路径没有父目录，则返回null
 * @author 刘建阳
 *
 */
public class FileDemo02 {

	public static void main(String[] args) {
		File file = new File("E:/workspace/SXT/IO流/io.jpg");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		
		file = new File("io.jpg");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		

	}

}
