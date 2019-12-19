package com.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 
 * @version:1.0
 * @Description:双向交流，加入多线程，发送端
 * @author:刘建阳
 * @date:2019年9月9日下午5:10:26
 */
public class TalkSend implements Runnable {
	// 1、使用DatagramSocket  指定端口 创建发送端
	private DatagramSocket client;
	// 2、准备数据 一定转成字节数组
	private BufferedReader br;
	private String address;
	private int toPort;
	public TalkSend(int port, String address, int toPort) {
		this.address = address;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String msg = br.readLine();
				byte[] datas = msg.getBytes();
				// 3、封装成DatagramPacket 包裹，需要指定目的地
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
						new InetSocketAddress(this.address, this.toPort));
				// 4、  发送包裹send​(DatagramPacket p) 
				this.client.send(packet);
				if (msg.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 5、释放资源 
		client.close();

	}


}
