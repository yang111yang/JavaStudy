package com.liujy.cooperation;

/**
 * 线程协作：生产者消费者模式的实现一：管程法
 * 管程法的几个元素：生产者、消费者、缓冲区、商品
 * @author 刘建阳
 *
 */
public class CooTest01 {
	
	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		new Productor(buffer).start();
		new Consumer(buffer).start();
	}

}

// 生产者
class Productor extends Thread {
	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("生产"+i+"个馒头");
			buffer.push(new SteamedBun(i));
		}
	}
	
}
// 消费者
class Consumer extends Thread {
	Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("获取"+buffer.pop().id+"个馒头");
		}
	}
}
// 缓冲区
class Buffer {
	// 容器
	SteamedBun[] buns = new SteamedBun[10];
	// 计数器
	int count = 0;
	
	// 存储数据
	public synchronized void push(SteamedBun bun) {
		// 容器中没有空间，调用wait方法
		if (count == buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 容器中有空间
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	
	// 获取数据
	public synchronized SteamedBun pop() {
		// 容器中没有数据，调用wait方法
		if (count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		SteamedBun bun = buns[count];
		this.notifyAll();
		return bun;
	}
}
// 馒头
class SteamedBun {
	int id;

	public SteamedBun(int id) {
		this.id = id;
	}
	
}
