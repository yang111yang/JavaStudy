package com.liujy.io2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 	文件字符输入流	加入缓冲流
 * 	步骤：
 * 	1、创建源
 * 	2、选择流
 * 	3、操作（读取文件）
 * 	4、释放资源
 * @author 刘建阳
 *
 */
public class BufferReaderTest {
	
	public static void main(String[] args) {
		// 1、创建源
		File src = new File("test.txt");
		// 2、选择流
		BufferedReader reader = null;
		try {
			// 3、操作
			reader = new BufferedReader(new FileReader(src));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
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
