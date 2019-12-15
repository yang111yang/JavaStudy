package com.liu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * @author liujy
 *
 */
public class Server {
	
	private ServerSocket serverSocket;
	private boolean isRunning;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	/** 启动服务 */
	public void start() {
		isRunning = true;
		try {
			serverSocket = new ServerSocket(8889);
			recevieAndSend();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败。。。。。。。");
		}
	}
	
	/** 处理信息 */
	public void recevieAndSend() {
		while (isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接");
				new Thread(new Dispatcher(client)).start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/** 停止服务 */
	public void stop() {
		isRunning = false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器停止失败。。。。。。。");
		}
	}

}
