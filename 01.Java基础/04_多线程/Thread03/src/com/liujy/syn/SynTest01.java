package com.liujy.syn;

/**
 * 线程安全(同步)：买票
 * 1.锁方法
 * 2.锁块
 * @author 刘建阳
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		SafeTicket ticket = new SafeTicket();
		
		new Thread(ticket,"码云").start();
		new Thread(ticket,"码农").start();
		new Thread(ticket,"码黄").start();
	}
}

class SafeTicket implements Runnable {
	// 票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
		
	}
	
	public synchronized void test() {
		if (ticketNums <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ticketNums--);
	}
}
