package com.net.udp;
/**
 * 
 * @version:1.0
 * @Description:在线咨询，学生
 * @author:刘建阳
 * @date:2019年9月9日下午5:20:18
 */
public class TalkStudent {

	public static void main(String[] args) {
		new Thread(new TalkSend(8888, "localhost", 9999)).start();// 发送
		new Thread(new TalkReceive(5555,"老师")).start(); // 接收
	}

}
