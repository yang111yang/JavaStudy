package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 	文件拷贝
 * @author 刘建阳
 *
 */
public class Copy {
	
	public static void main(String[] args) {
		copy("io.jpg","copy.jpg");
	}

	private static void copy(String srcPath, String destPth) {
		// 1、创建源
		File src = new File(srcPath);
		File dest = new File(destPth);
		// 2、选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			// 2、选择流
			is = new FileInputStream(src);
			os = new FileOutputStream(dest,true);
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
	}
		

}
