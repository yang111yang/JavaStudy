package com.liujy.state;
/**
 * join 合并线程，插队线程
 * @author 刘建阳
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
				t.join(); // main线程被阻塞了
			}
			System.out.println(i+"......main.........");
		}

	}

}
