package com.liujy.file;

import java.io.File;
import java.io.IOException;

/**
 * 	�����ļ���ɾ���ļ�
 * 	createNewFile()		�����ļ�
 * 	delete()	ɾ���ļ�
 * @author ������
 *
 */
public class FileDemo04 {

	public static void main(String[] args) throws IOException {
		File file = new File("E:/workspace/SXT/IO��/io.jpg");
		boolean flag = file.exists();
		System.out.println(flag);
		if (!flag) {
			file.createNewFile();
		}
//		file.delete();
		
		// ���䣺con��com3���ǲ���ϵͳ�ļ��������ܴ����ļ�
		file = new File("con2");
		file.createNewFile();
		file.delete();
	}

}
