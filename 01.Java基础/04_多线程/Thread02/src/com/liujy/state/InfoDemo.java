package com.liujy.state;
/**
 * 其他方法
 * @author 刘建阳
 *
 */
public class InfoDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isAlive());
		Thread.currentThread().setName("战斗机");
		System.out.println(Thread.currentThread());
	}

}
