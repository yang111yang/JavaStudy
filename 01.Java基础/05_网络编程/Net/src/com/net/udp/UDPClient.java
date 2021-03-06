package com.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @version:1.0
 * @Description:	
 * 	基本流程: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、封装成DatagramPacket 包裹，需要指定目的地
 * 4、  发送包裹send​(DatagramPacket p) 
 * 5、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午3:18:57
 */
public class UDPClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送端启动中。。。。。。。");
		// 1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2、准备数据 一定转成字节数组
		String msg = "我爱北京天安门";
		byte[] datas = msg.getBytes();
		// 3、封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost", 9999));
		// 4、  发送包裹send​(DatagramPacket p) 
		client.send(packet);
		// 5、释放资源 
		client.close();
	}

}
