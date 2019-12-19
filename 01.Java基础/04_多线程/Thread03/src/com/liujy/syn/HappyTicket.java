package com.liujy.syn;

/**
 * ���ֻ�Ʊ
 * @author ������
 *
 */
public class HappyTicket {
	
	public static void main(String[] args) {
		int avaiable = 2;
		Cinema cinema = new Cinema(avaiable, "���Ժ��");
		new Thread(new Customer(cinema, 2),"�ϸ�").start();
		new Thread(new Customer(cinema, 3), "����").start();
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

// ӰԺ
class Happy12306{
	int avaiable;
	String name;
	public Happy12306(int avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// ��Ʊ
	public synchronized boolean bookTicket(int seats) {
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
