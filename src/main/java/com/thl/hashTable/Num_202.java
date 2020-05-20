package com.thl.hashTable;

/**
 * 快乐数
 *编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 思路1：递归法 但是这种方式容易引起栈溢出
 *
 * 思路2：快慢指针法是解决循环问题的常用方法
 *
 */


public class Num_202 {

	public static void main(String[] args) {
		Num_202 test = new Num_202();
		boolean happy = test.isHappy(18);
		System.out.println(happy);
	}

	public boolean isHappy(int n) {
		if (n == 1)
			return true;
		int slow = n;
		int fast = n;
		do {
			slow = sum(slow);
			fast = sum(fast);
			fast = sum(fast);

		} while (fast != slow);

		return slow == 1;

	}

	public int sum(int n) {
		int sum = 0;
		while (n > 0) {
			int tail = n % 10;
			n = n / 10;
			sum += tail*tail;
		}

		return sum;
	}
}
