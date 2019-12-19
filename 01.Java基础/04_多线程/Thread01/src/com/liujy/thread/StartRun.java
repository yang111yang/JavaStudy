package com.liujy.thread;
/**
 * 	创建线程方式二：
 * 	实现继承Runnable，实现run方法
 * @author 刘建阳
 *
 */
public class StartRun implements Runnable {
	
	@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******吃鸡*******");
			}
		}

	public static void main(String[] args) {
		// 创建线程子类
//		StartRun thread = new StartRun();
		// 启动线程
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("------飞车------");
		}

	}

}
