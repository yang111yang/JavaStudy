package com.liujy.other;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ����ʱ���ȣ�Timer��TimerTask
 * @author ������
 *
 */
public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		timer.schedule(new MyTask(), 1000); // 1���Ӻ�ִ��
//		timer.schedule(new MyTask(), 1000, 2000); // 1���ÿ������ִ��һ��
		Calendar cal = new GregorianCalendar(2099,10,12,15,45,41);
		timer.schedule(new MyTask(), cal.getTime(), 2000); // 1���ÿ������ִ��һ��
	}
}

class MyTask extends TimerTask {

	public void run() {
		System.out.println("�ſմ��ԣ���Ϣһ��");
	}
	
}