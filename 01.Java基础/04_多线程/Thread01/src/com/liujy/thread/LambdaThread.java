package com.liujy.thread;
/**
 * 	Lambda���ʽ���Ƶ�
 * @author ������
 *
 */
public class LambdaThread {
	// ��̬�ڲ���
	static class ThreadTest implements Runnable {
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******�Լ�*******");
			}
		}
		
	}

	public static void main(String[] args) {
		// �����߳�����
//		StartRun thread = new StartRun();
		// �����߳�
		new Thread(new ThreadTest()).start();
		
		// �ֲ��ڲ���
		class ThreadTest1 implements Runnable {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******�Լ�*******");
				}
			}
		}
		
		new Thread(new ThreadTest1()).start();
		
		// �����ڲ���
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******�Լ�*******");
				}
			}
		}).start();
		
		// jdk1.8�� Lambda���ʽ
		new Thread(()-> {
				for (int i = 0; i < 20; i++) {
					System.out.println("*******�Լ�*******");
				}
			}).start();
	}

}
