package com.liujy.file;

import java.io.File;

/**
 * 	�ݹ�
 * 	��ȡĿ¼�����ＶĿ¼���ļ�������
 * @author ������
 *
 */
public class DirDemo04 {
	
	public static void main(String[] args) {
		File src = new File("E:/workspace/SXT/IO��/");
		printFileName(src,0);
	}
	
	public static void printFileName(File file, int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("*");
		}
		// ��ӡFile��
		System.out.println(file.getName());
		
		if (file == null || !file.exists()) { // �ݹ�ͷ
			return;
		} else {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					printFileName(f, deep+1); // �ݹ���
				}
			}
		}
		
	}

}
