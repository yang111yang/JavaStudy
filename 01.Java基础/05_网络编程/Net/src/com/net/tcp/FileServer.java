package com.net.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version:1.0
 * @Description:文件存储
 * 	创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:04:46
 */
public class FileServer {

	public static void main(String[] args) throws Exception {
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接。。。。");
		// 3、操作: 输入输出流操作
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("src/tcp.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = is.read(flush))!= -1) {
			os.write(flush, 0, len);
		}
		// 4、释放资源 
		os.close();
		is.close();
		client.close();
		
		server.close();
	}
}
