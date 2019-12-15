package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 	文件夹拷贝
 * 	出现的问题：递归调用copy方法是传入参数的路径容易搞错
 * @author 刘建阳
 *
 */
public class CopyDir {
	
	public static void main(String[] args) {
		copy("src/com","copyDir");
	}

	private static void copy(String srcPath, String destPath) {
		// 1、创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (src.exists()) {
			if (src.isFile()) {
				copyFile(src, dest);
			} else {
				File file2 = new File(dest.getAbsolutePath() +File.separator+ src.getName());
				file2.mkdirs();
				File[] subFiles = src.listFiles();
				for (File file : subFiles) {
					copy(file.getAbsolutePath(), file2.getAbsolutePath()+File.separator+file.getName());
				}
			}
		}
	}

	private static void copyFile(File src, File dest) {
		
		// 2、选择流
		InputStream is = null;
		OutputStream os = null;
		try {
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
