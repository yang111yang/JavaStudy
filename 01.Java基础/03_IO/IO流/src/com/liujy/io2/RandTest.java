package com.liujy.io2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 	支持读取和写入随机访问文件
 * 	分割文件
 * @author 刘建阳
 *
 */
public class RandTest {
	
	public static void main(String[] args) throws IOException {
		File src = new File("src/com/liujy/io2/Copy.java");
		// 计算文件分割后的起始位置和结束位置
		int beginPos = 0;
		int blockSize = 10;
		int length = (int) src.length();
		int actualSize = blockSize>length?length:blockSize;
		int size = (int) Math.ceil(length*1.0/blockSize);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			beginPos = i* blockSize;
			if (i == size-1) {
				actualSize = length;
			} else {
				actualSize = blockSize;
				length -= blockSize;
			}
			System.out.println(beginPos+"-->"+actualSize);
			split(beginPos, actualSize,i);
		}
	}
	
	public static void split(int beginPos,int actualSize, int i) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/liujy/io2/Copy.java"), "r");
		RandomAccessFile raf1 = new RandomAccessFile(new File("dest/"+"Copy"+i+".java"), "rw");
		raf.seek(beginPos);
		byte[] flush = new byte[1024];
		int len;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize>len) {
				raf1.write(flush,0,len);
			} else {
				raf1.write(flush, 0, actualSize);
				break;
			}
		}
		raf1.close();
		raf.close();
	}
	
	/**
	 * 	复制文件
	 * @throws IOException
	 */
	public static void test02() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/liujy/io2/Copy.java"), "r");
		RandomAccessFile raf1 = new RandomAccessFile(new File("Copy01.java"), "rw");
		int beginPos = 0;
		int blockSize = 1024;
		raf.seek(beginPos);
		byte[] flush = new byte[blockSize];
		int len;
		while ((len = raf.read(flush)) != -1) {
			raf1.write(flush);
		}
		raf.close();
	}
	
	/**
	 * 	使用RandomAccessFile读取文件内容
	 * @throws IOException
	 */
	public static void test01() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("src/com/liujy/io2/Copy.java"), "r");
		int beginPos = 0;
		int blockSize = 1024;
		raf.seek(beginPos);
		byte[] flush = new byte[blockSize];
		int len;
		while ((len = raf.read(flush)) != -1) {
			String str = new String(flush,0,len);
			System.out.println(str);
		}
		raf.close();
	}

}
