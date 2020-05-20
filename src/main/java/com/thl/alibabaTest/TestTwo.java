package com.thl.alibabaTest;

/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestTwo extends Thread {
	public static void main(String[] args) {
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				System.out.println("i'm thread A");
			}
		});

		Thread threadB = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("i'm thread B");
			}
		});

		TestTwo ThreadC = new TestTwo();
		threadA.start();
		threadB.start();
		ThreadC.start();

		try {
			threadA.join();
			threadB.join();
			ThreadC.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i'm threadC");
	}
}
