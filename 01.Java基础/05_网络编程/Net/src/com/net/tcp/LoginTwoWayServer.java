package com.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version:1.0
 * @Description:模拟登录陆 双向
 * 	创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:04:46
 */
public class LoginTwoWayServer {

	public static void main(String[] args) throws Exception {
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接。。。。");
		// 3、操作: 输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		String[] datas = msg.split("&");
		String username = "";
		String pwd = "";
		for (String userInfo : datas) {
			String[] userInfoArray = userInfo.split("=");
			if ("username".equals(userInfoArray[0])) {
				System.out.println("用户名为："+userInfoArray[1]);
				username = userInfoArray[1];
			} else if ("pwd".equals(userInfoArray[0])) {
				System.out.println("密码为："+userInfoArray[1]);
				pwd = userInfoArray[1];
			}
		}
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if ("laoliu".equals(username) && "1234".equals(pwd)) {
			dos.writeUTF("登录成功，欢迎回来");
		} else {
			dos.writeUTF("用户名或密码错误");
		}
		// 4、释放资源 
		dos.close();
		dis.close();
		client.close();
		
		server.close();
	}
}
