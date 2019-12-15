package com.liujy.other;

/**
 * 指令重排：HappenBefore
 * @author 刘建阳
 *
 */
public class HappenBefore {
	
	private static int a = 0;
	
	private static boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(()->{
				a = 1;
				flag = false;
			});
			
			Thread t2 = new Thread(()->{
				if (flag) {
					a *= 1;
				}
				// 出现指令重排
				if (a == 0) {
					System.out.println("HappenBefore a->"+a);
				}
			});
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}

	}

}
