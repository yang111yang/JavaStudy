package com.liujy.other;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务定时调度：Timer和TimerTask
 * @author 刘建阳
 *
 */
public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		timer.schedule(new MyTask(), 1000); // 1秒钟后执行
//		timer.schedule(new MyTask(), 1000, 2000); // 1秒后，每隔两秒执行一次
		Calendar cal = new GregorianCalendar(2099,10,12,15,45,41);
		timer.schedule(new MyTask(), cal.getTime(), 2000); // 1秒后，每隔两秒执行一次
	}
}

class MyTask extends TimerTask {

	public void run() {
		System.out.println("放空大脑，休息一下");
	}
	
}