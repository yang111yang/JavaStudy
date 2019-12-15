package com.liujy.thread;
/**
 * 	创建线程方式一：
 * 	继承Thread类，实现run方法
 * @author 刘建阳
 *
 */
public class StartThread extends Thread {
	
	@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******吃鸡*******");
			}
		}

	public static void main(String[] args) {
		// 创建线程子类
		StartThread thread = new StartThread();
		// 启动线程
		thread.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("------飞车------");
		}

	}

}
