package com.liujy.io1;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 	�ֽ�����������
 * 	��������
 * 	1������Դ ���ֽ�����
 * 	2��ѡ���� �����鳤�Ȳ�Ҫ̫��
 * 	3������
 * 	4���ͷ���Դ �����Բ����ͷ�
 * @author ������
 *
 */
public class IOTest06 {
	
	public static void main(String[] args) {
		// 1������Դ
		byte[] src = "talk is cheap show me the code".getBytes();
		
		InputStream is = null;
		try {
			// 2��ѡ����
			is = new ByteArrayInputStream(src);
			// 3������
			byte[] flush = new byte[5]; // ������
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				String str = new String(flush,0,len);
				System.out.println(str);
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
