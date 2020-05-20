package com.thl.multiThread;

import scala.reflect.internal.Trees;


public class SingletonForDCL {
	private static volatile student instance;  //作用：禁止指令重排

	public static student getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (SingletonForDCL.class) {
				if (instance == null) {
					instance = new student();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		student instance1 = SingletonForDCL.getInstance();
		student instance2 = SingletonForDCL.getInstance();
		student instance3 = SingletonForDCL.getInstance();
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
		System.out.println(instance3.hashCode());
	}

}

class student {
	private String name;
	private int age;

	public student() {
	}
}
