package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 	文件字节输入流
 * 	操作步骤（分段读取）
 * 	1、创建源
 * 	2、选择流
 * 	3、操作
 * 	4、释放资源
 * @author 刘建阳
 *
 */
public class IOTest02 {
	
	public static void main(String[] args) {
		// 1、创建源
		File src = new File("test.txt");
		
		InputStream is = null;
		try {
			// 2、选择流
			is = new FileInputStream(src);
			// 3、操作
			byte[] flush = new byte[1024]; // 缓冲区
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					// 4、释放资源
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
