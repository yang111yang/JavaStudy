package com.liujy.state;
/**
 * 	sleep ģ����Ϣ
 * @author ������
 *
 */
public class BlockedSleep04 implements Runnable {
	
	private int steps;

	@Override
	public void run() {
		while (true) {
			if (steps > 100) {
				break;
			}
			if (steps%10 == 0 && Thread.currentThread().getName().equals("����")) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "-->" + steps++);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new BlockedSleep04(), "�ڹ�").start();
		new Thread(new BlockedSleep04(), "����").start();
	}

}
