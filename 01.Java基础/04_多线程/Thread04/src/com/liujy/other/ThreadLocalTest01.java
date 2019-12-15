package com.liujy.other;

/**
 * ThreadLocal:每个线程自身存储的本地、局部区域 get/set/initialValue
 * 
 * @author 刘建阳
 *
 */
public class ThreadLocalTest01 {

//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	// 更改初始化值
	/*
	 * private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>()
	 * { protected Integer initialValue() { return 300; }; };
	 */
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->100);

	public static void main(String[] args) {
		// 获取值
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		// 设置值
		threadLocal.set(20);
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		
		new Thread(new MyRun()).start();
	}

	public static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int) (Math.random()*99));
			System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		}
	}
}

