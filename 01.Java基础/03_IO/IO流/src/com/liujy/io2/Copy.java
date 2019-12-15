package com.liujy.io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 	文件拷贝 使用字符缓冲流
 * @author 刘建阳
 *
 */
public class Copy {
	
	public static void main(String[] args) {
		copy("dest.txt","dest-copy.txt");
	}

	private static void copy(String srcPath, String destPath) {
		// 2、选择流
		try(BufferedReader br = new BufferedReader(new FileReader(srcPath));
				BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))) {
			// 3、操作
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

}
