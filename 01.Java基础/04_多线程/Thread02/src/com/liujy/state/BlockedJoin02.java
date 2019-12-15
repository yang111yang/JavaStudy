package com.liujy.state;
/**
 * join �ϲ��̣߳�����̣߳����ϰ��ö������̵Ĺ�������ʾ��
 * @author ������
 *
 */
public class BlockedJoin02 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Father());
		t.start();
	}

}

class Father extends Thread {
	@Override
	public void run() {
		System.out.println("�ϰ�����̣�������û��");
		System.out.println("�ϰ��ö���ȥ���̡�����");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//Father��������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�ϰ��õ��̣��ܸ��ˣ�����Ǯ���˶���");
	}
}

class Son extends Thread {
	@Override
	public void run() {
		System.out.println("��������Ǯȥ����");
		System.out.println("���ӷ���·���и���Ϸ������ȥ����10����");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"���ӹ�ȥ��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��Ȼ����Ҫ���̣��������˰��л��������̻ؼ���");
	}
}