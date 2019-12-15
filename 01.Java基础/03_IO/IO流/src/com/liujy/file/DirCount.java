package com.liujy.file;

import java.io.File;

/**
 * 	�ݹ�
 * 	��ȡ�ļ��еĴ�С���ļ��и������ļ�����
 * @author ������
 *
 */
public class DirCount {
	
	private long len;
	private int fileSize;
	private int dirSize = -1;
	private String path;
	private File file;
	
	
	public DirCount(String path) {
		this.path = path;
		file = new File(path);
		count(file);
	}


	public long getLen() {
		return len;
	}

	public int getFileSize() {
		return fileSize;
	}



	public int getDirSize() {
		return dirSize;
	}

	private void count(File file) {
		// ��ȡ�ļ��еĴ�С
		if (file != null && file.exists()) { // �ݹ�ͷ
			if (file.isFile()) {
				len += file.length();
				fileSize++;
			} else {
				dirSize++;
				File[] files = file.listFiles();
				for (File f : files) {
					count(f); // �ݹ���
				}
			}
		} 
	}

	public static void main(String[] args) {
		DirCount src = new DirCount("E:/workspace/SXT/IO��/");
		System.out.println(src.getLen()+"--->"+src.getDirSize()+"--->"+src.getFileSize());
	}

}
