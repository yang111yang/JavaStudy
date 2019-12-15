package com.liujy.io1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 	�ļ��ַ�������
 * 	���裺
 * 	1������Դ
 * 	2��ѡ����
 * 	3����������ȡ�ļ���
 * 	4���ͷ���Դ
 * @author ������
 *
 */
public class IOTest04 {
	
	public static void main(String[] args) {
		// 1������Դ
		File src = new File("test.txt");
		// 2��ѡ����
		Reader reader = null;
		try {
			// 3������
			reader = new FileReader(src);
			char[] flush = new char[1024];
			int read = reader.read(flush);
			System.out.println(new String(flush,0,read));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
