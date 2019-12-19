package com.liujy.syn;

/**
 * 线程不安全：取钱
 * @author 刘建阳
 *
 */
public class UnsafeTest03 {
	public static void main(String[] args) {
		Account account = new Account(100, "结婚礼金");
		Drawing you = new Drawing(account, 90, "无奈的你");
		Drawing wife = new Drawing(account, 80, "happy的对象");
		you.start();
		wife.start();
		
	}
}

// 模拟取款
class Drawing extends Thread {
	Account account;
	private int drawingMoney; // 取的钱数目
	private int packetMoney; // 包里的钱
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		account.money -= this.drawingMoney;
		this.packetMoney += this.drawingMoney;
		System.out.println(this.getName()+"-->账户余额为："+account.money);
		System.out.println(this.getName()+"-->口袋的钱为："+this.packetMoney);
	}
}
