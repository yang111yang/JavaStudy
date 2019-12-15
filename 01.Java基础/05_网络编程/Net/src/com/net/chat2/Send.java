package com.net.chat2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Description:发送端
 * @author:liujy
 * @version:1.0
 * @date:2019年9月12日上午11:36:19
 */
public class Send implements Runnable {
	
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	
	public Send(Socket client, String name) {
		this.client = client;
		isRunning = true;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
			e.printStackTrace();
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
	
	// 释放资源
	public void release() {
		isRunning = false;
		ChatUtils.close(dos,client);
	}

	@Override
	public void run() {
		while (isRunning) {
			// 发送消息
			this.send(ChatUtils.getStringFromConsole());
		}
	}

}
