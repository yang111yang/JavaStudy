package com.liujy.other;

/**
 * InheritableThreadLocal:继承上下文环境的数据，拷贝一份给子线程
 * 
 * @author 刘建阳
 *
 */
public class ThreadLocalTest04 {

	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		threadLocal.set(22);
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		
		// 线程有main线程开辟
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		}).start();
		
	}

}

