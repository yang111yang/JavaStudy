package com.liujy.commsio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 	文件的读取
 * @author 刘建阳
 *
 */
public class CIOTest03 {

	public static void main(String[] args) throws IOException {
		// 文件的读取
		String msg = FileUtils.readFileToString(new File("src/com/liujy/commsio/CIOTest01.java"), "GBK");
		System.out.println(msg);
	}
	
}
