package com.net.udp;
/**
 * 
 * @version:1.0
 * @Description:在线咨询，老师
 * @author:刘建阳
 * @date:2019年9月9日下午5:20:18
 */
public class TalkTeacher {

	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"学生")).start(); // 接收
		new Thread(new TalkSend(7777, "localhost", 5555)).start();// 发送
	}

}
