package com.liujy.thread;
/**
 * 	 ¹êÍÃÈüÅÜ
 * @author Áõ½¨Ñô
 *
 */
public class Racer implements Runnable {
	
	private int steps;

	@Override
	public void run() {
		while (true) {
			if (steps > 100) {
				break;
			}
			if (steps%10 == 0 && Thread.currentThread().getName().equals("ÍÃ×Ó")) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "-->" + steps++);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Racer(), "ÎÚ¹ê").start();
		new Thread(new Racer(), "ÍÃ×Ó").start();
	}

}
