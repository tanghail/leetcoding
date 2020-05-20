package com.thl.alibabaTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestTwo_four {
	private ReentrantLock lock;
	private Condition conditionA;
	private Condition conditionB;

	public TestTwo_four() {
		this.lock = new ReentrantLock();
		this.conditionB = lock.newCondition();
		this.conditionA = lock.newCondition();

	}

	public static void main(String[] args) {
		final TestTwo_four o = new TestTwo_four();

		new Thread(new Runnable() {
			public void run() {
				o.print_C();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				o.print_B();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				o.print_A();
			}
		}).start();


	}

	public void print_C () {
		lock.lock();
		try {
			conditionB.await();
			System.out.println("i' m  threadC");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();

	}

	public void print_A () {
		lock.lock();
		System.out.println("i' m  threadA");
		conditionA.signal();
		lock.unlock();
	}

	public void print_B () {
		lock.lock();
		try {
			conditionA.await();
			System.out.println("i' m  threadB");
			conditionB.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}



}

