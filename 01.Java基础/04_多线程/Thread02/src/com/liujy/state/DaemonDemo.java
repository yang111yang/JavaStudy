package com.liujy.state;
/**
 * �ػ��̣߳���Ϊ�û��̷߳���ģ�jvmֹͣ���õȴ��ػ��߳�ִ�����
 * Ĭ�ϵ��̣߳��û��̣߳�jvm�ȴ��û��߳�ִ����ϲŻ�ֹͣ
 * @author ������
 *
 */
public class DaemonDemo {

	public static void main(String[] args) {
		new Thread(new You()).start();
		God god = new God();
		Thread t = new Thread(god);
		// �����ػ��߳�
		t.setDaemon(true);
		t.start();
	}
	
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 365*100; i++) {
			System.out.println("happy life....");
		}
		System.out.println("oiooooooooooooo");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		for (;true;) {
			System.out.println("bless you....");
		}
	}
}