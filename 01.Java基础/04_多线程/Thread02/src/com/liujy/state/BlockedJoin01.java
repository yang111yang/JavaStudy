package com.liujy.state;
/**
 * join �ϲ��̣߳�����߳�
 * @author ������
 *
 */
public class BlockedJoin01 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i+"......lambda...........");
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				t.join(); // main�̱߳�������
			}
			System.out.println(i+"......main.........");
		}

	}

}
