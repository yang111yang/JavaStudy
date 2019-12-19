package com.liujy.thread;
/**
 * 	实现一份资源，多人共享(并发编程，线程安全)
 * @author 刘建阳
 *
 */
public class Web12306 implements Runnable {
	
	// 票数
	private int ticketNums = 100;

	@Override
	public void run() {
		while (true) {
			if (ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ticketNums--);
		}
		
	}

	public static void main(String[] args) {
		Web12306 web = new Web12306();
		
		new Thread(web,"码云").start();
		new Thread(web,"码农").start();
		new Thread(web,"码黄").start();
	}
}
