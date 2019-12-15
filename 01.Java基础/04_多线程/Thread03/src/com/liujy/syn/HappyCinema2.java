package com.liujy.syn;

public class HappyCinema2 {
	
	public static void main(String[] args) {
		int avaiable = 2;
		Cinema cinema = new Cinema(avaiable, "���Ժ��");
		new Thread(new Customer(cinema, 2),"�ϸ�").start();
		new Thread(new Customer(cinema, 3), "����").start();
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

// ӰԺ
class Cinema{
	int avaiable;
	String name;
	public Cinema(int avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// ��Ʊ
	public boolean bookTicket(int seats) {
		if (avaiable<=0) {
			return false;
		}
		synchronized (this) {
			if (avaiable<seats) {
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-->ʣ��λ�ã�"+avaiable);
				return false;
			}else {
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-->ʣ��λ�ã�"+avaiable);
				avaiable -= seats;
				return true;
			}
		}
	}
	
}
