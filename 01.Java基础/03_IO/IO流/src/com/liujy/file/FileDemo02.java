package com.liujy.file;

import java.io.File;

/**
 * 	�ļ�����·�������API
 * 	getName()	��ȡ�ļ���
 * 	getPath()	��ȡ�ļ�·���������ļ�����ʱ���õ���ʲô·�������·�����߾���·���������صľ���ʲô·��
 * 	getAbsolutePath()	��ȡ�ļ��ľ���·��
 * 	getParent()		��ȡ�ļ��ĸ�·���������ļ�����ʱ�����·��������������ļ�����ʱ�����·��û�и�Ŀ¼���򷵻�null
 * @author ������
 *
 */
public class FileDemo02 {

	public static void main(String[] args) {
		File file = new File("E:/workspace/SXT/IO��/io.jpg");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		
		file = new File("io.jpg");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		

	}

}
