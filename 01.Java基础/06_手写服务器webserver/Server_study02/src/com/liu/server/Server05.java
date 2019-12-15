package com.liu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 封装请求信息
 * 处理请求参数和中文
 * @author liujy
 *
 */
public class Server05 {
	
	private ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		Server05 server = new Server05();
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
			Request02 request = new Request02(client);
			
			send(client,request);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	
	// 返回响应内容
	public void send(Socket client, Request02 request) throws IOException {
		Response response = new Response(client);
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("服务器响应");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("响应内容回来了......." + request.getParaValue("uname"));
		response.print("</body>");
		response.print("</html>");
		
		response.push(200);
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
