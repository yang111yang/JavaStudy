package com.liujy.file;

import java.io.File;

/**
 * 	�ݹ�
 * 	��ȡ�ļ��еĴ�С
 * @author ������
 *
 */
public class DirDemo05 {
	
	public static void main(String[] args) {
		File src = new File("E:/workspace/SXT/IO��/");
		count(src);
		System.out.println(len);
	}
	public static long len;
	public static void count(File file) {
		// ��ȡ�ļ��еĴ�С
		if (file != null && file.exists()) { // �ݹ�ͷ
			if (file.isFile()) {
				len += file.length();
			} else {
				File[] files = file.listFiles();
				for (File f : files) {
					count(f); // �ݹ���
				}
			}
		} 
	}

}
