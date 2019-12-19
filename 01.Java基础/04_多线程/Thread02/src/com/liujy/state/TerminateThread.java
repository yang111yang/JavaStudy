package com.liujy.state;
/**
 * 	终止线程的两种方式：
 * 1.程序正常结束
 * 2.加入标识
 * @author 刘建阳
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
		TerminateThread tt = new TerminateThread("C罗");
		new Thread(tt).start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 88) {
				tt.terminate();
			}
			System.out.println("主线程"+"--->"+i);
		}
	}
	
}
