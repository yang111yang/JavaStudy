package com.liujy.io2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 	�ļ��ַ�������	���뻺����
 * 	���裺
 * 	1������Դ
 * 	2��ѡ����
 * 	3����������ȡ�ļ���
 * 	4���ͷ���Դ
 * @author ������
 *
 */
public class BufferReaderTest {
	
	public static void main(String[] args) {
		// 1������Դ
		File src = new File("test.txt");
		// 2��ѡ����
		BufferedReader reader = null;
		try {
			// 3������
			reader = new BufferedReader(new FileReader(src));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
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
