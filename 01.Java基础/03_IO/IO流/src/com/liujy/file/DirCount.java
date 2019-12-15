package com.liujy.file;

import java.io.File;

/**
 * 	递归
 * 	获取文件夹的大小，文件夹个数，文件个数
 * @author 刘建阳
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
		// 获取文件夹的大小
		if (file != null && file.exists()) { // 递归头
			if (file.isFile()) {
				len += file.length();
				fileSize++;
			} else {
				dirSize++;
				File[] files = file.listFiles();
				for (File f : files) {
					count(f); // 递归体
				}
			}
		} 
	}

	public static void main(String[] args) {
		DirCount src = new DirCount("E:/workspace/SXT/IO流/");
		System.out.println(src.getLen()+"--->"+src.getDirSize()+"--->"+src.getFileSize());
	}

}
