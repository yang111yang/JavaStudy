package com.liujy.syn;

/**
 * 快乐火车票
 * @author 刘建阳
 *
 */
public class HappyTicket {
	
	public static void main(String[] args) {
		int avaiable = 2;
		Cinema cinema = new Cinema(avaiable, "万达院线");
		new Thread(new Customer(cinema, 2),"老高").start();
		new Thread(new Customer(cinema, 3), "老刘").start();
	}

}

class Passager implements Runnable{

	Cinema cinema;
	private int seats;
	
	
	public Passager(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		cinema.bookTicket(seats);
	}
	
}

// 影院
class Happy12306{
	int avaiable;
	String name;
	public Happy12306(int avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// 购票
	public synchronized boolean bookTicket(int seats) {
		if (avaiable<=0) {
			return false;
		}
		synchronized (this) {
			if (avaiable<seats) {
				System.out.println("出票失败"+Thread.currentThread().getName()+"-->剩余位置："+avaiable);
				return false;
			}else {
				System.out.println("出票成功"+Thread.currentThread().getName()+"-->剩余位置："+avaiable);
				avaiable -= seats;
				return true;
			}
		}
	}
	
}
