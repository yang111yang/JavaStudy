package com.liujy.thread;
/**
 * 	�����̷߳�ʽ����
 * 	ʵ�ּ̳�Runnable��ʵ��run����
 * @author ������
 *
 */
public class StartRun implements Runnable {
	
	@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("*******�Լ�*******");
			}
		}

	public static void main(String[] args) {
		// �����߳�����
//		StartRun thread = new StartRun();
		// �����߳�
		new Thread(new StartRun()).start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("------�ɳ�------");
		}

	}

}
