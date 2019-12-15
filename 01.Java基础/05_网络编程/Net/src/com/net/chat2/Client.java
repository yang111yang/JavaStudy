package com.net.chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version:1.0
 * @Description:聊天室：客户端
 *  加入容器实现群聊
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		System.out.println("请输入姓名：");
		String name = br.readLine();
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}

}
