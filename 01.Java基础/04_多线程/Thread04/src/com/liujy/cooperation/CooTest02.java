package com.liujy.cooperation;

/**
 * 线程协作：生产者消费者模式的实现二：信号灯法
 * 信号灯法
 * @author 刘建阳
 *
 */
public class CooTest02 {
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		new Player(tv).start();;
		new Watcher(tv).start();;
	}

}

// 生产者 演员
class Player extends Thread {
	Tv tv;
	
	public Player(Tv tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			tv.play("天空之城");
		}
	}
	
}
// 消费者 观众
class Watcher extends Thread {
	Tv tv;
	
	public Watcher(Tv tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			tv.watch();
		}
	}
}
// 电视
class Tv {
	String voice; // 表演内容
	boolean flag = true; // 标志位 T:演员表演 观众等待 F:演员等待 观众观看
	

	// 表演
	public synchronized void play(String voice) {
		// 演员表演 观众等待
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("表演了"+voice);
		this.voice = voice;
		this.notifyAll(); 
		flag = !flag;
	}
	
	// 获取数据
	public synchronized void watch() {
		// 演员表演 观众等待
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("观看了"+voice);
		this.notifyAll(); 
		flag = !flag;
	}
}
