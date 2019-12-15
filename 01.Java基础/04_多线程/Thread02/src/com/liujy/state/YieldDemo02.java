package com.liujy.state;
/**
 * yield 礼让线程，调用该方法后线程进入就绪状态
 * @author 刘建阳
 *
 */
public class YieldDemo02 {
	
	public static void main(String[] args) {
		new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i+"......lambda...........");
			}
		}).start();
		
		for (int i = 0; i < 100; i++) {
			if (i%20 == 0) {
				Thread.yield();
			}
			System.out.println(i+"......main.........");
		}
	}

}

