package com.liujy.syn;

/**
 * �̲߳���ȫ��ȡǮ
 * @author ������
 *
 */
public class UnsafeTest03 {
	public static void main(String[] args) {
		Account account = new Account(100, "������");
		Drawing you = new Drawing(account, 90, "���ε���");
		Drawing wife = new Drawing(account, 80, "happy�Ķ���");
		you.start();
		wife.start();
		
	}
}

// ģ��ȡ��
class Drawing extends Thread {
	Account account;
	private int drawingMoney; // ȡ��Ǯ��Ŀ
	private int packetMoney; // �����Ǯ
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		account.money -= this.drawingMoney;
		this.packetMoney += this.drawingMoney;
		System.out.println(this.getName()+"-->�˻����Ϊ��"+account.money);
		System.out.println(this.getName()+"-->�ڴ���ǮΪ��"+this.packetMoney);
	}
}
