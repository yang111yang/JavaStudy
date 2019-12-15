package com.liujy.io2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 	�ļ��ֽ������	���뻺����
 * 	�������裨�ֶζ�ȡ��
 * 	1������Դ
 * 	2��ѡ����
 * 	3������
 * 	4���ͷ���Դ
 * @author ������
 *
 */
public class BufferedTest02 {
	
	public static void main(String[] args) {
		// 1������Դ
		File dest = new File("dest.txt");
		// 2��ѡ����
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(dest,true));
			String msg = "����һֻСС��\r\n";
			byte[] flush = msg.getBytes(); // �ַ�-->�ֽڣ����룩
			os.write(flush);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		

}
