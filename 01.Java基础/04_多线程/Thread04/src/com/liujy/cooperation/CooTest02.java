package com.liujy.cooperation;

/**
 * �߳�Э����������������ģʽ��ʵ�ֶ����źŵƷ�
 * �źŵƷ�
 * @author ������
 *
 */
public class CooTest02 {
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		new Player(tv).start();;
		new Watcher(tv).start();;
	}

}

// ������ ��Ա
class Player extends Thread {
	Tv tv;
	
	public Player(Tv tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			tv.play("���֮��");
		}
	}
	
}
// ������ ����
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
// ����
class Tv {
	String voice; // ��������
	boolean flag = true; // ��־λ T:��Ա���� ���ڵȴ� F:��Ա�ȴ� ���ڹۿ�
	

	// ����
	public synchronized void play(String voice) {
		// ��Ա���� ���ڵȴ�
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("������"+voice);
		this.voice = voice;
		this.notifyAll(); 
		flag = !flag;
	}
	
	// ��ȡ����
	public synchronized void watch() {
		// ��Ա���� ���ڵȴ�
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ۿ���"+voice);
		this.notifyAll(); 
		flag = !flag;
	}
}
