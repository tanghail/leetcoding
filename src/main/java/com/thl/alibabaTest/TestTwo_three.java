package com.thl.alibabaTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestTwo_three extends Thread {
	private CyclicBarrier lock;

	public TestTwo_three() {
		this.lock = new CyclicBarrier(2, this);
	}

	public static void main(String[] args) {
		final TestTwo_three o = new TestTwo_three();

		new Thread(new Runnable() {
			public void run() {
				o.print_B();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				o.print_A();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void run() {
		System.out.println("i' m  threadC");
	}

	public void print_A () {
		System.out.println("i' m  threadA");
		try {
			lock.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public void print_B () {
		System.out.println("i' m  threadB");
		try {
			lock.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}


}

