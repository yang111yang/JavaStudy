package com.liujy.state;

import java.io.IOException;

/**
 *	
 * 	sleep ģ�⵹��ʮ�����������һ��
 * @author ������
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
