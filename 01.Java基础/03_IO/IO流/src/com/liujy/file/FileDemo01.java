package com.liujy.file;

import java.io.File;

/**
 *	 �����ļ�����
 * @author ������
 *
 */
public class FileDemo01 {

	public static void main(String[] args) {
		// ��һ�ֹ�����ʽ File(String parent, String child)
		File file1 = new File("E:/workspace/SXT/IO��", "io.jpg");
		
		// �ڶ��ֹ�����ʽ File(File parent, String child)
		File file2 = new File(new File("E:/workspace/SXT/IO��"), "io.jpg");
		
		// �����ֹ�����ʽ File(String name)
		File file3 = new File("io.jpg");
		
		// �����ֹ�����ʽ File(String path)
		File file4 = new File("E:/workspace/SXT/IO��/io.jpg");
		
	}
	
}
