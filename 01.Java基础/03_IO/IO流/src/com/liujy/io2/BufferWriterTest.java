package com.liujy.io2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 	�ļ��ַ������	���뻺����
 * 	���裺
 * 	1������Դ
 * 	2��ѡ����
 * 	3��������д�����ݣ�
 * 	4���ͷ���Դ
 * @author ������
 *
 */
public class BufferWriterTest {
	public static void main(String[] args) {
		// 1������Դ
		File dest = new File("dest.txt");
		// 2��ѡ����
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			// 3������
			// д��һ
//			String msg = "�Ұ������찲��";
//			char[] flush = msg.toCharArray();
//			writer.write(flush);
			
			// д����
//			String msg = "�찲����̫����";
//			writer.write(msg);
			
			// д����
			writer.append("�Ұ�����ɫ�ĺ���");
			writer.newLine();
			writer.append("����ĺ����зḻ�ı���");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
