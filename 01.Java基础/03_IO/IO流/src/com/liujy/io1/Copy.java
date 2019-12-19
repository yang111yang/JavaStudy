package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 	�ļ�����
 * @author ������
 *
 */
public class Copy {
	
	public static void main(String[] args) {
		copy("io.jpg","copy.jpg");
	}

	private static void copy(String srcPath, String destPth) {
		// 1������Դ
		File src = new File(srcPath);
		File dest = new File(destPth);
		// 2��ѡ����
		InputStream is = null;
		OutputStream os = null;
		try {
			// 2��ѡ����
			is = new FileInputStream(src);
			os = new FileOutputStream(dest,true);
			// 3������
			byte[] flush = new byte[1024]; // ������
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ	�����ȴ򿪵ĺ�ر�
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
