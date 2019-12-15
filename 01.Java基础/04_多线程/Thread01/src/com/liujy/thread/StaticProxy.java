package com.liujy.thread;
/**
 * 	静态代理模式
 * 	接口：代理者和被代理者实现
 * 	典型的静态代理模式：new Thread(new Runnable()).start();
 * @author 刘建阳
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		new MarryCompany(new You()).happyMarry();
	}
	
}

interface Marry {
	void happyMarry();
}

class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("终于要结婚了。。。。。");
	}
	
}

class MarryCompany implements Marry {

	private You target;
	
	
	public MarryCompany(You target) {
		this.target = target;
	}

	@Override
	public void happyMarry() {
		before();
		target.happyMarry();
		after();
	}

	private void after() {
		System.out.println("闹洞房。。。。。。。。");
	}

	private void before() {
		System.out.println("新房布置美哒哒。。。。");
	}
	
}