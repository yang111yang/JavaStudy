package com.liujy.other;
/**
 * Volatile:用于保证数据的同步性，但是不能保证原子性
 * @author 刘建阳
 *
 */
public class VolatileTest {
	
	private volatile static int num = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while (num == 0) {
				
			}
		}).start(); 
		
		Thread.sleep(1000);
		num = 1;
	}

}
