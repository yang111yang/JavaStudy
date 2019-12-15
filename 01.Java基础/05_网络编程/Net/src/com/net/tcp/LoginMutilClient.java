package com.net.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @version:1.0
 * @Description:模拟登录陆 多用户
 * 	创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class LoginMutilClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		// 2、操作: 输入输出流操作
		new Send(client).send();
		new Receive(client).receive();
		client.close();
		
	}

	static class Send {
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader br;
		private String msg;
		
		public Send(Socket client) {
			this.client = client;
			try {
				dos = new DataOutputStream(this.client.getOutputStream());
				br = new BufferedReader(new InputStreamReader(System.in));
				msg = init();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private String init() {
			String username = "";
			String pwd = "";
			try {
				System.out.println("请输入用户名：");
				username = br.readLine();
				System.out.println("请输入密码：");
				pwd = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "username=" + username + "&" + "pwd=" + pwd;
		}
		
	}
	
	static class Receive {
		
		private DataInputStream dis;
		private Socket client;
		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(this.client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String receive() {
			String result = "";
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
	}

}
