package com.thl.multiThread;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CasForTest {
	private int i;
	private AtomicInteger atomicI = new AtomicInteger(0);

	private ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		/**
		 * 创建100个线程，每个线程通过非线程安全和线程安全的方式实现自家，打印最后的结果
		 */
		ArrayList<Thread> threads = new ArrayList<Thread>();
		final CasForTest casForTest = new CasForTest();
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 1000; j++) {
						casForTest.count();
						casForTest.safeCount();
					}
				}
			});
			threads.add(thread);
		}

		//启动线程
		for (Thread t : threads)
			t.start();

		//等待所有线程执行玩
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//打印结果
		System.out.println(casForTest.i);
		System.out.println(casForTest.atomicI.get());
	}

	public void safeCount() {
		for (;;){
			int i = atomicI.get();
			boolean sucess = atomicI.compareAndSet(i, ++i);

			//如果旧值一致，表示自加成功
			if (sucess) {
				break;
			}

		}
	}

	public void count (){
		lock.lock();
		i++;
		lock.unlock();
	}
}
