package com.liujy.io2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 	文件字节输出流	加入缓冲流
 * 	操作步骤（分段读取）
 * 	1、创建源
 * 	2、选择流
 * 	3、操作
 * 	4、释放资源
 * @author 刘建阳
 *
 */
public class BufferedTest02 {
	
	public static void main(String[] args) {
		// 1、创建源
		File dest = new File("dest.txt");
		// 2、选择流
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(dest,true));
			String msg = "我是一只小小鸟\r\n";
			byte[] flush = msg.getBytes(); // 字符-->字节（编码）
			os.write(flush);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		

}
