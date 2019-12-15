package com.liujy.state;
/**
 * 	sleep	Ä£ÄâÍøÂçÑÓÊ±
 * @author Áõ½¨Ñô
 *
 */
public class BlockedSleep03 implements Runnable {
	
	// Æ±Êı
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
		
		new Thread(web,"ÂëÔÆ").start();
		new Thread(web,"ÂëÅ©").start();
		new Thread(web,"Âë»Æ").start();
	}
}
