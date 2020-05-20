package com.thl.alibabaTest;

import java.util.concurrent.CountDownLatch;

/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestTwo_two {
	private static CountDownLatch lock = new CountDownLatch(2);

	public static void main(String[] args) {
		final TestTwo_two o = new TestTwo_two();
		Thread threadC = new Thread(new Runnable() {
			public void run() {
				o.print_C();
			}
		});

		Thread threadA = new Thread(new Runnable() {
			public void run() {
				o.print_A();
			}
		});

		Thread threadB = new Thread(new Runnable() {
			public void run() {
				o.print_B();
			}
		});

		threadA.start();
		threadB.start();
		threadC.start();

	}

	public void print_C () {
		try {
			lock.await();
			System.out.println("i' m  threadC");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void print_A () {
		System.out.println("i' m  threadA");
		lock.countDown();
	}

	public void print_B () {
		System.out.println("i' m  threadB");
		lock.countDown();
	}


}

