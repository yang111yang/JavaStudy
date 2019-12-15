package com.liujy.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ʹ��try...with...resource
 * ʹ�ø��߼�����Ҫ�����ͷ���Դ
 * @author ������
 *
 */
public class FileUtils2 {
	
	public static void main(String[] args) {
		copy("io.jpg","copy.jpg");
	}

	private static void copy(String srcPath, String destPth) {
		// 1������Դ
		File src = new File(srcPath);
		File dest = new File(destPth);
		// 2��ѡ����
		try (InputStream is = new FileInputStream(src);
				OutputStream os = new FileOutputStream(dest,true);) {
			// 2��ѡ����
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
		}
	}
		

}
