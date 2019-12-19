package com.net.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version:1.0
 * @Description:文件上传
 * 	创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class FileClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		// 2、操作: 输入输出流操作
		InputStream is = new BufferedInputStream(new FileInputStream("src/ndl.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = is.read(flush))!= -1) {
			os.write(flush, 0, len);
		}
		// 3、释放资源 
		os.close();
		is.close();
		client.close();
	}

}
