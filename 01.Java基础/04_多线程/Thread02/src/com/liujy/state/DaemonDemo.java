package com.liujy.state;
/**
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认的线程：用户线程，jvm等待用户线程执行完毕才会停止
 * @author 刘建阳
 *
 */
public class DaemonDemo {

	public static void main(String[] args) {
		new Thread(new You()).start();
		God god = new God();
		Thread t = new Thread(god);
		// 设置守护线程
		t.setDaemon(true);
		t.start();
	}
	
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 365*100; i++) {
			System.out.println("happy life....");
		}
		System.out.println("oiooooooooooooo");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		for (;true;) {
			System.out.println("bless you....");
		}
	}
}