package com.liujy.thread;
/**
 * 	�����̷߳�ʽһ��
 * 	�̳�Thread�࣬ʵ��run����
 * @author ������
 *
 */
public class StartThread extends Thread {
	
	@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******�Լ�*******");
			}
		}

	public static void main(String[] args) {
		// �����߳�����
		StartThread thread = new StartThread();
		// �����߳�
		thread.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("------�ɳ�------");
		}

	}

}
