package com.thl.alibabaTest;

/**
 * 请实现让10个任务同时并发启动，给些代码片段。
 *
 */

public class TestOne {
	public static void main(String[] args) {

		for (int i = 0; i < 10 ; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println("i'm coding");
				}
			}).start();
		}

	}
}
