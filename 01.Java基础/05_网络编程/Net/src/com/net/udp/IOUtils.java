package com.net.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 	图片 --> 程序 -->  字节数组
 * 	字节数组 --> 程序 --> 图片
 * 	（实际上就是一个文件的拷贝）
 * @author 刘建阳
 *
 */
public class IOUtils {
	
	public static void main(String[] args) {
		byte[] datas = fileToByteArray("io.jpg");
		System.out.println(datas.length);
		byteArrayToFile(datas, "io-byte.jpg");
		
	}
		
	/**
	 * 图片 --> 程序 -->  字节数组
	 */
	public static byte[] fileToByteArray(String filePath) {
		// 1、创建源
		File src = new File(filePath);
		// 2、选择流
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		try {
			baos = new ByteArrayOutputStream();
			is = new FileInputStream(src);
			// 3、操作
			byte[] flush = new byte[1024]; // 缓冲区
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				baos.write(flush,0,len);
			}
			baos.flush();
			return baos.toByteArray();
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
		return null;
	}

	/**
	 * 字节数组 --> 程序 --> 图片
	 */
	public static void byteArrayToFile(byte[] datas, String filePath) {
		// 1、创建源
		File dest = new File(filePath);
		// 2、选择流
		OutputStream os = null;
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(datas);
			os = new FileOutputStream(dest,true);
			// 3、操作
			byte[] flush = new byte[1024*10]; // 缓冲区
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
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
