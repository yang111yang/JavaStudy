package com.liujy.io2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 	文件字符输出流	加入缓冲流
 * 	步骤：
 * 	1、创建源
 * 	2、选择流
 * 	3、操作（写入内容）
 * 	4、释放资源
 * @author 刘建阳
 *
 */
public class BufferWriterTest {
	public static void main(String[] args) {
		// 1、创建源
		File dest = new File("dest.txt");
		// 2、选择流
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			// 3、操作
			// 写法一
//			String msg = "我爱北京天安门";
//			char[] flush = msg.toCharArray();
//			writer.write(flush);
			
			// 写法二
//			String msg = "天安门上太阳升";
//			writer.write(msg);
			
			// 写法三
			writer.append("我爱这蓝色的海洋");
			writer.newLine();
			writer.append("祖国的海疆有丰富的宝藏");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
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
