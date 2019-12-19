package com.liujy.io1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 	文件字符输入流
 * 	步骤：
 * 	1、创建源
 * 	2、选择流
 * 	3、操作（读取文件）
 * 	4、释放资源
 * @author 刘建阳
 *
 */
public class IOTest04 {
	
	public static void main(String[] args) {
		// 1、创建源
		File src = new File("test.txt");
		// 2、选择流
		Reader reader = null;
		try {
			// 3、操作
			reader = new FileReader(src);
			char[] flush = new char[1024];
			int read = reader.read(flush);
			System.out.println(new String(flush,0,read));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
