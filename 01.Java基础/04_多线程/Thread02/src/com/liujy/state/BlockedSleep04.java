package com.liujy.state;
/**
 * 	sleep 模拟休息
 * @author 刘建阳
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
			if (steps%10 == 0 && Thread.currentThread().getName().equals("兔子")) {
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
		new Thread(new BlockedSleep04(), "乌龟").start();
		new Thread(new BlockedSleep04(), "兔子").start();
	}

}
