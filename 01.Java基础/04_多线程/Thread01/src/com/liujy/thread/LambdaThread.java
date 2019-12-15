package com.liujy.thread;
/**
 * 	Lambda表达式的推导
 * @author 刘建阳
 *
 */
public class LambdaThread {
	// 静态内部类
	static class ThreadTest implements Runnable {
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******吃鸡*******");
			}
		}
		
	}

	public static void main(String[] args) {
		// 创建线程子类
//		StartRun thread = new StartRun();
		// 启动线程
		new Thread(new ThreadTest()).start();
		
		// 局部内部类
		class ThreadTest1 implements Runnable {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******吃鸡*******");
				}
			}
		}
		
		new Thread(new ThreadTest1()).start();
		
		// 匿名内部类
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******吃鸡*******");
				}
			}
		}).start();
		
		// jdk1.8简化 Lambda表达式
		new Thread(()-> {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******吃鸡*******");
				}
			}).start();
	}

}
