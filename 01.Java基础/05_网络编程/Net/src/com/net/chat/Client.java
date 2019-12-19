package com.net.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version:1.0
 * @Description:聊天室：客户端
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
	}

}
