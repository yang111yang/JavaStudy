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
 * @Description:模拟登录陆 双向
 * 	创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午8:07:42
 */
public class LoginTwoWayClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String username = br.readLine();
		System.out.println("请输入密码：");
		String pwd = br.readLine();
		
		
		// 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		// 2、操作: 输入输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String msg = "username=" + username + "&" + "pwd=" + pwd;
		dos.writeUTF(msg);
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result = dis.readUTF();
		System.out.println(result);
		// 3、释放资源 
		dis.close();
		dos.close();
		client.close();
	}

}
