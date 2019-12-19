package com.net.chat3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @Description:接收端
 * @author:liujy
 * @version:1.0
 * @date:2019年9月12日上午11:36:02
 */
public class Receive implements Runnable {
	
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	
	public Receive(Socket client) {
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
			isRunning = true;
		} catch (IOException e) {
			System.out.println("----3----");
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
		ChatUtils.close(dis,client);
	}

	@Override
	public void run() {
		while (isRunning) {
			// 3、操作: 输入输出流操作
			// 接收消息
			String msg = this.receive();
			System.out.println(msg);
		}
	}

}