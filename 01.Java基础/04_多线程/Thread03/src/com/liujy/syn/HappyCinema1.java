package com.liujy.syn;

import java.util.ArrayList;
import java.util.List;
/**
 * 快乐影院
 * @author 刘建阳
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
		WDCinema cinema = new WDCinema(avaiable, "万达院线");
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(5);
		seats2.add(6);
		new Thread(new HappyCustomer(cinema, seats1),"老高").start();
		new Thread(new HappyCustomer(cinema, seats2), "老刘").start();
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

// 影院
class WDCinema{
	List<Integer> avaiable;
	String name;
	public WDCinema(List<Integer> avaiable, String name) {
		this.avaiable = avaiable;
		this.name = name;
	}
	
	// 购票
	public boolean bookTicket(List<Integer> seats) {
		synchronized (this) {
			List<Integer> copy = new ArrayList<Integer>();
			copy.addAll(avaiable);
			copy.removeAll(seats);
			if (avaiable.size()-copy.size() != seats.size()) {
				System.out.println("出票失败"+Thread.currentThread().getName()+"-->剩余位置："+avaiable);
				return false;
			}else {
				System.out.println("出票成功"+Thread.currentThread().getName()+"-->剩余位置："+avaiable);
				avaiable = copy;
				return true;
			}
		}
	}
	
}
