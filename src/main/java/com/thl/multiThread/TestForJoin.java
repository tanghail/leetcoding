package com.thl.multiThread;

import com.thl.test.threadPool.Hello;

public class TestForJoin {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start time ==" + System.currentTimeMillis());
		Thread1 thread1 = new Thread1();
		thread1.start();
		thread1.join(10000);
		System.out.println("end time ==" + System.currentTimeMillis());
	}

}

class Thread1 extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("Hello");
		try {
			Thread.sleep(3000);
			System.out.println("join thread end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
