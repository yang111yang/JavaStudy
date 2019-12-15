package com.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version:1.0
 * @Description:聊天室：服务端
 * @author:刘建阳
 * @date:2019年9月9日下午8:04:46
 */
public class Chat {

	public static void main(String[] args) throws Exception {
		// 1、指定端口 使用ServerSocket创建服务器
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8888);
		while (true) {
			// 2、阻塞式等待连接 accept
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接。。。。");
			new Thread(new Channel(client)).start();
		}
	}
	
	// 一个客户端对应一个Channel
	static class Channel implements Runnable {
		
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning;
		private Socket client;
		
		public Channel(Socket client) {
			this.client = client;
			isRunning = true;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				System.out.println("----1----");
				this.release();
			}
		}
		
		// 发送消息
		public void send (String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("----2----");
				this.release();
			}
		}
		
		// 接收消息
		public String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				System.out.println("----4----");
				this.release();
			}
			return msg;
		}
		// 释放资源
		public void release() {
			isRunning = false;
			ChatUtils.close(dis,dos,client);
		}

		@Override
		public void run() {
			while (isRunning) {
				// 3、操作: 输入输出流操作
				// 接收消息
				String msg = this.receive();
				// 发送消息
				this.send(msg);
			}
		}
		
	}
}
