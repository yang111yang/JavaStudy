package com.liujy.state;
/**
 * 	��ֹ�̵߳����ַ�ʽ��
 * 1.������������
 * 2.�����ʶ
 * @author ������
 *
 */
public class TerminateThread implements Runnable {
	
	private boolean flag = true;
	private String name;
	

	public TerminateThread(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		int a = 0;
		while (flag) {
			System.out.println(name+"----"+ a++);
			
		}
	}
	
	public void terminate() {
		this.flag = false;
		System.out.println("game over");
	}

	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread("C��");
		new Thread(tt).start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 88) {
				tt.terminate();
			}
			System.out.println("���߳�"+"--->"+i);
		}
	}
	
}
