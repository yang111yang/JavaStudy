package com.liujy.other;

/**
 * ThreadLocal:分析上下文环境
 * 
 * @author 刘建阳
 *
 */
public class ThreadLocalTest03 {

	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

	public static void main(String[] args) {
		new Thread(new MyRun()).start();
	}

	public static class MyRun implements Runnable{
		
		public MyRun() {
			System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		}

		@Override
		public void run() {
			threadLocal.set(333);
			System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		}
	}
}

