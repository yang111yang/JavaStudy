package com.liujy.syn;

/**
 * �̰߳�ȫ��ȡǮ
 * @author ������
 *
 */
public class SynBlockTest01 {
	public static void main(String[] args) {
		Account account = new Account(1000, "������");
		SynDrawing you = new SynDrawing(account, 90, "���ε���");
		SynDrawing wife = new SynDrawing(account, 80, "happy�Ķ���");
		you.start();
		wife.start();
		
	}
}



// ģ��ȡ��
class SynDrawing extends Thread {
	Account account;
	private int drawingMoney; // ȡ��Ǯ��Ŀ
	private int packetMoney; // �����Ǯ
	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	// �̰߳�ȫ
	private void test() {
		// ����֮ǰ�жϣ���������
		if (account.money<=0) {
			return;
		}
		// ͬ����
		synchronized(account) {
			if (account.money<drawingMoney) {
				return;
			}
			account.money -= this.drawingMoney;
			this.packetMoney += this.drawingMoney;
			System.out.println(this.getName()+"-->�˻����Ϊ��"+account.money);
			System.out.println(this.getName()+"-->�ڴ���ǮΪ��"+this.packetMoney);
		}
	}
}
