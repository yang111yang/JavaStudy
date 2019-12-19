package com.liujy.other;
/**
 * 不可重入锁：锁不可以延续使用
 * @author 刘建阳
 *
 */

public class LockTest02 {
	Lock lock = new Lock();
	
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}
	
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println("...........");
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest02 test = new LockTest02();
		test.a();
		test.doSomething();
	}

}
// 不可重入锁
class Lock {
	// 锁是否被占用
	private boolean isLocked = false;
	// 使用锁
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}
	// 释放锁
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}
