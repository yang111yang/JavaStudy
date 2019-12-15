package com.liujy.syn;

/**
 * 线程不安全：买票
 * @author 刘建阳
 *
 */
public class UnsafeTest01 {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket,"码云").start();
		new Thread(ticket,"码农").start();
		new Thread(ticket,"码黄").start();
	}
}

class Ticket implements Runnable {
	// 票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
		
	}
	
	public void test() {
		if (ticketNums<0) {
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
