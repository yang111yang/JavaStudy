package com.liujy.file;

import java.io.File;
import java.io.IOException;

/**
 * 	�ж�״̬
 * 	exists()	�ж��ļ�����Ŀ¼�Ƿ����
 * 	isFile()	�ж��Ƿ�Ϊ�ļ�
 * 	isDirectory()	�ж��Ƿ�ΪĿ¼
 * @author ������
 *
 */
public class FileDemo03 {

	public static void main(String[] args) throws IOException {
		File file = new File("E:/workspace/SXT/IO��/io.jpg");
		boolean flag = file.exists();
		System.out.println(flag);
		
		// �ж�״̬�ı�׼����
		if (!file.exists()) {
			System.out.println("�ļ������ڣ������ļ��ɹ�");
		} else {
			if (file.isFile()) {
				System.out.println("���ļ������Ǹ��ļ�");
			} else {
				System.out.println("���ļ������Ǹ�Ŀ¼");
			}
		}
		
	}

}
