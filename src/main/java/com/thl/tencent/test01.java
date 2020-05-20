package com.thl.tencent;


import java.util.LinkedList;
import java.util.Scanner;

public class test01 {
	private static LinkedList queue = new  LinkedList<Long>();


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int times = Integer.parseInt(in.nextLine());
		while (times != 0 && in.hasNext()){
			Long countOfOp = Long.parseLong(in.nextLine());
			for (int j = 0; j < countOfOp; j++) {
				String line = in.nextLine();
				String[] s = line.split(" ");
				if (s.length == 2)
					getOperator(s[0], Long.parseLong(s[1]));
				else getOperator(s[0], null);
			}
			times--;
		}

	}
	public static void getOperator(String op, Long value){
		test01 test = new test01();
		switch (op) {
			case "PUSH":
				test.push(value);
				break;
			case "TOP":
				test.top();
				break;
			case "POP":
				test.pop();
				break;
			case "SIZE":
				test.size();
				break;
			case "CLEAR":
				test.clear();
				break;
			default:
				System.out.println("-1");
		}
	}

	//插入队尾
	public void push(long value){
		queue.addLast(value);
	}

	//取出队首
	public void top(){
		int res;
		if (!queue.isEmpty())
			res = (Integer) queue.getFirst();
		else res = -1;

		System.out.println(res);
	}

	//删除队首
	public void pop() {
		if (!queue.isEmpty())
			queue.removeFirst();
		else System.out.println(-1);
	}

	//队列大小
	public void size(){
		System.out.println(queue.size());
	}

	//清空队列
	public void clear(){
		queue.clear();
	}
}
