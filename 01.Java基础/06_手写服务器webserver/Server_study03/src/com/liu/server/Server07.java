package com.liu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 添加配置文件
 * @author liujy
 *
 */
public class Server07 {
	
	private ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		Server07 server = new Server07();
		server.start();
	}
	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}
	// 获取信息
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			Request request = new Request(client);
			
			Response response = new Response(client);
			Servlet servlet = WebApp.getServletFromUrl(request.getRequestUrl());
			if (servlet != null) {
				servlet.service(request, response);
				response.push(200);
			} else {
				response.push(404);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	
		
	// 停止服务
	public void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器停止失败");
		}
	}
	
}
