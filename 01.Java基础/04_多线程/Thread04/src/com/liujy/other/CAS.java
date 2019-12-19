package com.liujy.other;
/**
 * CAS：比较并交换，是一种多线程的思想，其底层不是使用synchronized实现的
 * @author 刘建阳
 *
 */

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
	
	// 库存
	private static AtomicInteger stock = new AtomicInteger(5);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer left = stock.decrementAndGet();
				if (left < 1) {
					System.out.println("抢完了。。。。");
					return;
				}
				System.out.println(Thread.currentThread()+"抢到了一件商品");
				System.out.println("-----还剩下"+left+"件商品");
			}).start();
		}
	}
	

}
