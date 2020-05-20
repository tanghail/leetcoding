package com.thl.alibabaTest;

/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestTwo_five {
	public static void main(String[] args) {
		final Object o = new Object();
		new Thread(new Runnable() {
			public void run() {
				synchronized (o) {
					try {
						o.wait();
						System.out.println("我后执行............");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				synchronized (o) {
					System.out.println("我先执行.........");
					o.notify();
				}
			}
		}).start();
	}

}
