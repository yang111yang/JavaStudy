package com.liujy.syn;

/**
 * 线程不安全：操作容器
 * @author 刘建阳
 *
 */
public class SynBlockTest03 {
	public static void main(String[] args) {
		BlockSafeTicket ticket = new BlockSafeTicket();
		
		new Thread(ticket,"码云").start();
		new Thread(ticket,"码农").start();
		new Thread(ticket,"码黄").start();
	}
}

class BlockSafeTicket implements Runnable {
	// 票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test4();
		}
		
	}
	
	// 尽可能锁定合理的范围
	// double checking
	public void test4() {
		// 提升性能
		if (ticketNums <= 0) { // 检测没有票的情况
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNums <= 0) { // 检测只有一张票的情况
				flag = false;
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ticketNums--);
		}
	}
	
	// 锁的范围太大，性能不高
	public void test3() {
		synchronized (this) {
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
	
	// 锁的对象不对，应该是锁对象，而不是锁对象的属性
	public void test2() {
		synchronized ((Integer)ticketNums) {
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
	
	// 锁的范围太大，性能不高
	public synchronized void test1() {
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

