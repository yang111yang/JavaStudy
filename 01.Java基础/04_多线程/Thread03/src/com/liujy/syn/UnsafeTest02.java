package com.liujy.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：操作容器
 * @author 刘建阳
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(list.size());
	}
}

