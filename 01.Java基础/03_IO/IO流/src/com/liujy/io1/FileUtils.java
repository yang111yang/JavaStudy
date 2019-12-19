package com.liujy.io1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1.��װ������
 * 2.��װ�ͷ���Դ
 */
public class FileUtils {

	public static void main(String[] args) {
		// �ļ��ֽ��������ļ�
		try {
			// 2��ѡ����
			InputStream is = new FileInputStream("test.txt");
			OutputStream os = new FileOutputStream("test-copy.txt");
			copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �ļ����Ƶ��ڴ�
		byte[] datas = null;
		try {
			// 2��ѡ����
			InputStream is = new FileInputStream("io.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);
			datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �ڴ渴�Ƶ��ļ�
		try {
			// 2��ѡ����
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("io-copy.jpg");
			copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copy(InputStream is, OutputStream os) {
		try {
			// 3������
			byte[] flush = new byte[1024]; // ������
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ	�����ȴ򿪵ĺ�ر�
//			close(is, os);
			close(is);
			close(os);
		}
	}
	
	/**
	 * �ͷ���Դ
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is, OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ͷ���Դ
	 * @param io
	 */
	public static void close(Closeable io) {
		try {
			if (io != null) {
				io.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
