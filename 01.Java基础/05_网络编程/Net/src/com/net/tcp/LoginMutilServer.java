package com.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version:1.0
 * @Description:模拟登录陆 多用户(使用多线程封装)
 * 	创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:04:46
 */
public class LoginMutilServer {

	public static void main(String[] args) throws Exception {
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		boolean flag = true;
		while (flag) {
			// 2、阻塞式等待连接 accept
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接。。。。");
			
			new Thread(new Channel(client)).start();
		}
		server.close();
	}
	
	// 一个客户端连接
	static class Channel implements Runnable {
		
		private Socket client;
		private DataInputStream dis; // 输入流
		private DataOutputStream dos; // 输出流
		public Channel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 接收
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return msg;
		}
		// 发送
		private void send(String username, String pwd) {
				try {
					if ("laoliu".equals(username) && "1234".equals(pwd)) {
						dos.writeUTF("登录成功，欢迎回来");
					} else {
						dos.writeUTF("用户名或密码错误");
					}
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		// 释放资源
		private void release() {
			// 4、释放资源 
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 3、操作: 输入输出流操作
			String[] datas = receive().split("&");
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
			send(username, pwd);
			release();
			
		}
		
	}
}
