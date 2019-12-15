package com.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version:1.0
 * @Description:熟悉流程
 * 	创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		// 2、操作: 输入输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String msg = "hello";
		dos.writeUTF(msg);
		// 3、释放资源 
		dos.close();
		client.close();
	}

}
