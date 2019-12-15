package com.liu.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现多线程，加入分发器
 * @author liujy
 *
 */
public class Server {
	
	private ServerSocket serverSocket = null;
	private boolean isRunning;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	// 获取信息
	public void receive() {
		while (isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接");
				new Thread(new Dispatcher(client)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}
	
		
	// 停止服务
	public void stop() {
		isRunning = false;
		try {
			serverSocket.close();
			System.out.println("服务器停止");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器停止失败");
		}
	}
	
}
