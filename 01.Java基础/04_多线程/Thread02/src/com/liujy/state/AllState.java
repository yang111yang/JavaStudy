package com.liujy.state;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * @author 刘建阳
 *
 */
public class AllState {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			System.out.println("----------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		State state = t.getState();
		System.out.println(state); // NEW
		
		t.start();
		state = t.getState();
		System.out.println(state); // RUNNABLE
		
		while (true) {
			int num = Thread.activeCount(); // 当前程序的线程数
			if (num == 1) {
				break;
			}
			Thread.sleep(200);
			state = t.getState();
			System.out.println(state); //TIMED_WAITING TERMINATED
		}
	}
}
