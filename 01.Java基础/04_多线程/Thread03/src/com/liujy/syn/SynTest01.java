package com.liujy.syn;

/**
 * �̰߳�ȫ(ͬ��)����Ʊ
 * 1.������
 * 2.����
 * @author ������
 *
 */
public class SynTest01 {
	public static void main(String[] args) {
		SafeTicket ticket = new SafeTicket();
		
		new Thread(ticket,"����").start();
		new Thread(ticket,"��ũ").start();
		new Thread(ticket,"���").start();
	}
}

class SafeTicket implements Runnable {
	// Ʊ��
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
