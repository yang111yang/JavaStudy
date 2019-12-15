package com.liujy.commsio;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 	获取文件和目录的大小
 * @author 刘建阳
 *
 */
public class CIOTest01 {

	public static void main(String[] args) {
		// 读取文件的大小
		long len = FileUtils.sizeOf(new File("src/com/liujy/commsio/CIOTest01.java"));
		System.out.println(len);
		
		// 读取目录的大小
		len = FileUtils.sizeOf(new File("E:/workspace/SXT/IO/CommonsIOTest"));
		System.out.println(len);
	}
	
}
