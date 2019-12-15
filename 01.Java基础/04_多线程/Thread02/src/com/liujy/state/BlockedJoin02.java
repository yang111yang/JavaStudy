package com.liujy.state;
/**
 * join 合并线程，插队线程（以老爸让儿子买烟的故事来演示）
 * @author 刘建阳
 *
 */
public class BlockedJoin02 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Father());
		t.start();
	}

}

class Father extends Thread {
	@Override
	public void run() {
		System.out.println("老爸想抽烟，发现烟没了");
		System.out.println("老爸让儿子去买烟。。。");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join();//Father被阻塞了
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("老爸拿到烟，很高兴，把零钱给了儿子");
	}
}

class Son extends Thread {
	@Override
	public void run() {
		System.out.println("儿子拿着钱去买烟");
		System.out.println("儿子发现路边有个游戏厅，进去玩了10秒钟");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+"秒钟过去了");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("忽然想起要买烟，儿子买了包中华，拿着烟回家了");
	}
}