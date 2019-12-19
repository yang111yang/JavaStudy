package com.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * @version:1.0
 * @Description:	
 * 	引用类型: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、将引用基本类型数据转成字节数组
 * 3、封装成DatagramPacket 包裹，需要指定目的地
 * 4、  发送包裹send​(DatagramPacket p) 
 * 5、释放资源 
 * @author:刘建阳
 * @date:2019年9月9日下午3:18:57
 */
public class UDPObjClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送端启动中。。。。。。。");
		// 1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2、准备数据 一定转成字节数组
		// 写入的对象是文件
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream dos = new ObjectOutputStream(baos);
		dos.writeUTF("一剑霜寒十四州");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.writeDouble(1.00);
		dos.writeObject("燕山月似钩");
		dos.writeObject(new Date());
		dos.writeObject(new Employee("李鸿章",100.00));
		dos.flush();
		byte[] datas = baos.toByteArray();

		// 3、封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost", 9999));
		// 4、  发送包裹send​(DatagramPacket p) 
		client.send(packet);
		// 5、释放资源 
		dos.close();
		client.close();
	}

}
