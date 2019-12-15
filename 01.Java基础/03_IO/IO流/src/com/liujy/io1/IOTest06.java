package com.liujy.io1;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 	字节数组输入流
 * 	操作步骤
 * 	1、创建源 ：字节数组
 * 	2、选择流 ：数组长度不要太大
 * 	3、操作
 * 	4、释放资源 ：可以不用释放
 * @author 刘建阳
 *
 */
public class IOTest06 {
	
	public static void main(String[] args) {
		// 1、创建源
		byte[] src = "talk is cheap show me the code".getBytes();
		
		InputStream is = null;
		try {
			// 2、选择流
			is = new ByteArrayInputStream(src);
			// 3、操作
			byte[] flush = new byte[5]; // 缓冲区
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
