package com.liujy.syn;

public class HappyCinema2 {
	
	public static void main(String[] args) {
		int avaiable = 2;
		Cinema cinema = new Cinema(avaiable, "万达院线");
		new Thread(new Customer(cinema, 2),"老高").start();
		new Thread(new Customer(cinema, 3), "老刘").start();
	}

}

class Customer implements Runnable{

	Cinema cinema;
	private int seats;
	
	
	public Customer(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		cinema.bookTicket(seats);
	}
	
}

// 影院
class Cinema{
	int avaiable;
	String name;
	public Cinema(int avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// 购票
	public boolean bookTicket(int seats) {
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
