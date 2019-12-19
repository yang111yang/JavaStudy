package com.liu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 加入Servlet，解耦了业务代码
 * @author liujy
 *
 */
public class Server06 {
	
	private ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		Server06 server = new Server06();
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
			Servlet servlet = null;
			if (request.getRequestUrl().equals("login")) {
				servlet = new LoginServlet();
			} else if (request.getRequestUrl().equals("reg")) {
				servlet = new RegisterServlet();
			} else {
				// 首页...
			}
			servlet.service(request, response);
				
			response.push(200);
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
