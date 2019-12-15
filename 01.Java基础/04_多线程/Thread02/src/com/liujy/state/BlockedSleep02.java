package com.liujy.state;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *	
 * 	sleep 模拟倒计时
 * @author 刘建阳
 *
 */
public class BlockedSleep02 {
	public static void main(String[] args) throws InterruptedException, IOException {
		Date date = new Date(System.currentTimeMillis()+1000*10);
		long end = date.getTime();
		while (true) {
			Thread.sleep(1000);
			System.out.println(new SimpleDateFormat("mm:ss").format(date));
			date = new Date(date.getTime()-1000);
			if (end - 1000*10 > date.getTime()) {
				break;
			}
		}
	}
}
