package com.liujy.file;

import java.io.File;

/**
 * 	创建目录
 * 	1、mkdir() 上一级目录必须存在
 * 	2、mkdirs()	上级目录可以不存在，不存在是会自动创建
 * @author 刘建阳
 *
 */
public class DirDemo01 {
	
	public static void main(String[] args) {
		// mkdir()
		File dir = new File("E:/workspace/SXT/IO流/dir/test");
		System.out.println(dir.mkdir()); // false
		
		dir = new File("E:/workspace/SXT/IO流/dir");
		System.out.println(dir.mkdir()); // true
		dir.delete();
		
		
		// mkdirs()
		dir = new File("E:/workspace/SXT/IO流/dir/test");
		System.out.println(dir.mkdirs()); // true
	}

}
