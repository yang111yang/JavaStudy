package com.liujy.io1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1.封装流操作
 * 2.封装释放资源
 */
public class FileUtils {

	public static void main(String[] args) {
		// 文件字节流复制文件
		try {
			// 2、选择流
			InputStream is = new FileInputStream("test.txt");
			OutputStream os = new FileOutputStream("test-copy.txt");
			copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 文件复制到内存
		byte[] datas = null;
		try {
			// 2、选择流
			InputStream is = new FileInputStream("io.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 内存复制到文件
		try {
			// 2、选择流
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("io-copy.jpg");
			copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copy(InputStream is, OutputStream os) {
		try {
			// 3、操作
			byte[] flush = new byte[1024]; // 缓冲区
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源	规则：先打开的后关闭
//			close(is, os);
			close(is);
			close(os);
		}
	}
	
	/**
	 * 释放资源
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is, OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 * @param io
	 */
	public static void close(Closeable io) {
		try {
			if (io != null) {
				io.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
