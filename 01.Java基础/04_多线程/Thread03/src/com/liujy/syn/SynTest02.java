package com.liujy.syn;

/**
 * �̰߳�ȫ(ͬ��)��ȡǮ
 * 1.������
 * 2.����
 * ���ֿ飺
 * 1���ڷ����ڲ����Ǿֲ���
 * 2�������е��ǹ����
 * 3�������м���static�Ǿ�̬��
 * 4������synchronized��ͬ����
 * @author ������
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		Account account = new Account(100, "������");
		Drawing you = new Drawing(account, 90, "���ε���");
		Drawing wife = new Drawing(account, 80, "happy�Ķ���");
		you.start();
		wife.start();
		
	}
}



// ģ��ȡ��
class SafeDrawing extends Thread {
	Account account;
	private int drawingMoney; // ȡ��Ǯ��Ŀ
	private int packetMoney; // �����Ǯ
	public SafeDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	// ���Ķ��󲻶ԣ�Ӧ����account��������this
	private synchronized void test() {
		if (account.money<drawingMoney) {
			return;
		}
		account.money -= this.drawingMoney;
		this.packetMoney += this.drawingMoney;
		System.out.println(this.getName()+"-->�˻����Ϊ��"+account.money);
		System.out.println(this.getName()+"-->�ڴ���ǮΪ��"+this.packetMoney);
	}
}
