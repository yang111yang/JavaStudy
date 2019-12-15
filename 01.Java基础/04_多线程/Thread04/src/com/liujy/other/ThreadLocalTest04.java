package com.liujy.other;

/**
 * InheritableThreadLocal:�̳������Ļ��������ݣ�����һ�ݸ����߳�
 * 
 * @author ������
 *
 */
public class ThreadLocalTest04 {

	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		threadLocal.set(22);
		System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		
		// �߳���main�߳̿���
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
		}).start();
		
	}

}

