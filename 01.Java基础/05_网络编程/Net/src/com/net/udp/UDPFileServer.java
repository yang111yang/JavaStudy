package com.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @version:1.0
 * @Description:	文件存储：接收端
 * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 * 1、使用DatagramSocket  指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、  阻塞式接收包裹receive​(DatagramPacket p)
 * 4、分析数据
 *    byte[]  getData​()
 *                getLength​()
 * 5、释放资源
 * @author:刘建阳
 * @date:2019年9月9日下午3:57:10
 */
public class UDPFileServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收端启动中。。。。。。。");
		// 1、使用DatagramSocket  指定端口 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		// 2、准备容器 封装成DatagramPacket 包裹
		byte[] container = new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,container.length);
		// 3、  阻塞式接收包裹receive​(DatagramPacket p)
		server.receive(packet);
		// 4、分析数据
		IOUtils.byteArrayToFile(container, "src/copy.png");
		// 5、释放资源
		server.close();
	}

}
