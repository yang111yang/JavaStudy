package com.liujy.syn;

/**
 * 线程安全：取钱
 * @author 刘建阳
 *
 */
public class SynBlockTest01 {
	public static void main(String[] args) {
		Account account = new Account(1000, "结婚礼金");
		SynDrawing you = new SynDrawing(account, 90, "无奈的你");
		SynDrawing wife = new SynDrawing(account, 80, "happy的对象");
		you.start();
		wife.start();
		
	}
}



// 模拟取款
class SynDrawing extends Thread {
	Account account;
	private int drawingMoney; // 取的钱数目
	private int packetMoney; // 包里的钱
	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		test();
	}
	// 线程安全
	private void test() {
		// 在锁之前判断，提升性能
		if (account.money<=0) {
			return;
		}
		// 同步块
		synchronized(account) {
			if (account.money<drawingMoney) {
				return;
			}
			account.money -= this.drawingMoney;
			this.packetMoney += this.drawingMoney;
			System.out.println(this.getName()+"-->账户余额为："+account.money);
			System.out.println(this.getName()+"-->口袋的钱为："+this.packetMoney);
		}
	}
}
