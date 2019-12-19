package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 	�ļ��ֽ�������
 * 	��������
 * 	1������Դ
 * 	2��ѡ����
 * 	3������
 * 	4���ͷ���Դ
 * @author ������
 *
 */
public class IOTest01 {
	
	public static void main(String[] args) {
		// 1������Դ
		File src = new File("test.txt");
		
		InputStream is = null;
		try {
			// 2��ѡ����
			is = new FileInputStream(src);
			// 3������
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.println((char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					// 4���ͷ���Դ
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
