package com.thl.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈实现队列
 *
 *
 */

public class test02 {
	private Stack<Long> stack1 = new Stack<Long>();
	private Stack<Long> stack2 = new Stack<Long>();
	private int size = 0;


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ops = Long.parseLong(in.nextLine());
		test02 test = new test02();
		for (int i = 0; i < ops; i++) {
			String line = in.nextLine();
			String[] s = line.split(" ");
			if (s.length == 2)
				test.getOperator(s[0], Long.parseLong(s[1]));
			else test.getOperator(s[0], null);
		}
	}

	public  void getOperator(String op, Long value){
		switch (op) {
			case "add":
				add(value);
				break;
			case "pop":
				poll();
				break;
			case "peek":
				peek();
				break;
		}
	}
	public void add(Long value) {
		if (size == 0)
			stack1.push(value);
		else {
			if (!stack1.isEmpty())
				stack1.push(value);
			else {
				transfer(stack2, stack1);
				stack1.push(value);
			}
		}

		size++;
	}

	public void poll() {
		if (size != 0) {
			if (stack1.isEmpty())
				stack2.pop();

			else {
				transfer(stack1, stack2);
				stack2.pop();
			}

			size--;
		}
	}

	public void peek() {
		if (size != 0) {
			Long peek;
			if (stack1.isEmpty()) {
				peek = stack2.peek();
			} else {
				transfer(stack1, stack2);
				peek = stack2.peek();
			}

			System.out.println(peek);
		}

	}

	public void transfer(Stack<Long> left, Stack<Long> right) {
		// left to right
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
	}
}
