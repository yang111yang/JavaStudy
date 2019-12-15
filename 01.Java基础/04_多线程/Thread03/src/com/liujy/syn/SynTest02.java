package com.liujy.syn;

/**
 * 线程安全(同步)：取钱
 * 1.锁方法
 * 2.锁块
 * 四种块：
 * 1）在方法内部的是局部块
 * 2）在类中的是构造块
 * 3）在类中加了static是静态块
 * 4）加了synchronized是同步块
 * @author 刘建阳
 *
 */
public class SynTest02 {
	public static void main(String[] args) {
		Account account = new Account(100, "结婚礼金");
		Drawing you = new Drawing(account, 90, "无奈的你");
		Drawing wife = new Drawing(account, 80, "happy的对象");
		you.start();
		wife.start();
		
	}
}



// 模拟取款
class SafeDrawing extends Thread {
	Account account;
	private int drawingMoney; // 取的钱数目
	private int packetMoney; // 包里的钱
	public SafeDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	// 锁的对象不对，应该锁account，而不是this
	private synchronized void test() {
		if (account.money<drawingMoney) {
			return;
		}
		account.money -= this.drawingMoney;
		this.packetMoney += this.drawingMoney;
		System.out.println(this.getName()+"-->账户余额为："+account.money);
		System.out.println(this.getName()+"-->口袋的钱为："+this.packetMoney);
	}
}
