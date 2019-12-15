package com.liujy.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;;

/**
 * 线程安全：操作容器
 * @author 刘建阳
 *
 */
public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		// 操作并发容器
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(5000);
		System.out.println(list.size());
	}
	
	public void test() throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()-> {
				// 同步块
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(5000);
		System.out.println(list.size());
	}
}

