package com.liujy.cooperation;

/**
 * �߳�Э����������������ģʽ��ʵ��һ���̷ܳ�
 * �̷ܳ��ļ���Ԫ�أ������ߡ������ߡ�����������Ʒ
 * @author ������
 *
 */
public class CooTest01 {
	
	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		new Productor(buffer).start();
		new Consumer(buffer).start();
	}

}

// ������
class Productor extends Thread {
	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("����"+i+"����ͷ");
			buffer.push(new SteamedBun(i));
		}
	}
	
}
// ������
class Consumer extends Thread {
	Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("��ȡ"+buffer.pop().id+"����ͷ");
		}
	}
}
// ������
class Buffer {
	// ����
	SteamedBun[] buns = new SteamedBun[10];
	// ������
	int count = 0;
	
	// �洢����
	public synchronized void push(SteamedBun bun) {
		// ������û�пռ䣬����wait����
		if (count == buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �������пռ�
		buns[count] = bun;
		count++;
		this.notifyAll();
	}
	
	// ��ȡ����
	public synchronized SteamedBun pop() {
		// ������û�����ݣ�����wait����
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
// ��ͷ
class SteamedBun {
	int id;

	public SteamedBun(int id) {
		this.id = id;
	}
	
}
