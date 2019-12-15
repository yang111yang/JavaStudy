package com.liujy.state;
/**
 * yield 礼让线程，调用该方法后线程进入就绪状态
 * @author 刘建阳
 *
 */
public class YieldDemo01 {
	
	public static void main(String[] args) {
		Yield yield = new Yield();
		new Thread(yield,"a").start();
		new Thread(yield,"b").start();
	}

}

class Yield implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->start");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"-->end");
	}
	
}
