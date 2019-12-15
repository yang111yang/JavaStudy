package com.liujy.syn;

/**
 * �̲߳���ȫ����������
 * @author ������
 *
 */
public class SynBlockTest03 {
	public static void main(String[] args) {
		BlockSafeTicket ticket = new BlockSafeTicket();
		
		new Thread(ticket,"����").start();
		new Thread(ticket,"��ũ").start();
		new Thread(ticket,"���").start();
	}
}

class BlockSafeTicket implements Runnable {
	// Ʊ��
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test4();
		}
		
	}
	
	// ��������������ķ�Χ
	// double checking
	public void test4() {
		// ��������
		if (ticketNums <= 0) { // ���û��Ʊ�����
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNums <= 0) { // ���ֻ��һ��Ʊ�����
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
	
	// ���ķ�Χ̫�����ܲ���
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
	
	// ���Ķ��󲻶ԣ�Ӧ���������󣬶����������������
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
	
	// ���ķ�Χ̫�����ܲ���
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

