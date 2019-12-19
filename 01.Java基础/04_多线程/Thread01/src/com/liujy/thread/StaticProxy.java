package com.liujy.thread;
/**
 * 	��̬����ģʽ
 * 	�ӿڣ������ߺͱ�������ʵ��
 * 	���͵ľ�̬����ģʽ��new Thread(new Runnable()).start();
 * @author ������
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
		System.out.println("����Ҫ����ˡ���������");
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
		System.out.println("�ֶ�������������������");
	}

	private void before() {
		System.out.println("�·����������ա�������");
	}
	
}