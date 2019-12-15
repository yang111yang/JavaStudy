package com.liujy.syn;

import java.util.ArrayList;
import java.util.List;
/**
 * ����ӰԺ
 * @author ������
 *
 */
public class HappyCinema1 {
	
	public static void main(String[] args) {
		List<Integer> avaiable = new ArrayList<Integer>();
		avaiable.add(1);
		avaiable.add(2);
		avaiable.add(3);
		avaiable.add(5);
		avaiable.add(7);
		avaiable.add(8);
		WDCinema cinema = new WDCinema(avaiable, "���Ժ��");
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(5);
		seats2.add(6);
		new Thread(new HappyCustomer(cinema, seats1),"�ϸ�").start();
		new Thread(new HappyCustomer(cinema, seats2), "����").start();
	}

}

class HappyCustomer implements Runnable{

	WDCinema cinema;
	private List<Integer> seats;
	
	
	public HappyCustomer(WDCinema cinema, List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		cinema.bookTicket(seats);
	}
	
}

// ӰԺ
class WDCinema{
	List<Integer> avaiable;
	String name;
	public WDCinema(List<Integer> avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// ��Ʊ
	public boolean bookTicket(List<Integer> seats) {
		synchronized (this) {
			List<Integer> copy = new ArrayList<Integer>();
			copy.addAll(avaiable);
			copy.removeAll(seats);
			if (avaiable.size()-copy.size() != seats.size()) {
				System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-->ʣ��λ�ã�"+avaiable);
				return false;
			}else {
				System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"-->ʣ��λ�ã�"+avaiable);
				avaiable = copy;
				return true;
			}
		}
	}
	
}
