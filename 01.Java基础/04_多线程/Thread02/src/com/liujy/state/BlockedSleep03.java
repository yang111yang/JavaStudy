package com.liujy.state;
/**
 * 	sleep	ģ��������ʱ
 * @author ������
 *
 */
public class BlockedSleep03 implements Runnable {
	
	// Ʊ��
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
		BlockedSleep03 web = new BlockedSleep03();
		
		new Thread(web,"����").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}
