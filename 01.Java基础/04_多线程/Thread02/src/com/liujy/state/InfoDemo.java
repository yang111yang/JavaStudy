package com.liujy.state;
/**
 * ��������
 * @author ������
 *
 */
public class InfoDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isAlive());
		Thread.currentThread().setName("ս����");
		System.out.println(Thread.currentThread());
	}

}
