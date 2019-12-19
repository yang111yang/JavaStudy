package com.liujy.state;

import java.io.IOException;

/**
 *	
 * 	sleep 模拟倒数十个数，间隔是一秒
 * @author 刘建阳
 *
 */
public class BlockedSleep01 {
	public static void main(String[] args) throws InterruptedException, IOException {
		int num = 10;
		while (true) {
			if (num == 0) {
				break;
			}
			System.out.println(num--);
			Thread.sleep(1000);
		}
	}
}
