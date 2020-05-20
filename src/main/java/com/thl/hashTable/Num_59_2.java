package com.thl.hashTable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 思路一：本题最直观的思路是通过每次遍历队列找到最大的值，不过这样每个操作的时间负责度会为O(n)
 *
 * 思路二：将最大值保存在一个双端队列中，保证双端队列的元素从头部开始是单调递减的
 *
 */


public class Num_59_2 {
	int maxHead = 0;
	int maxTail = 0;
	int dataHead = 0;
	int dataTail = 0;
	int[] maxQueue;
	int[] dataQueue;

	public Num_59_2() {
		/**
		 * 队列是从尾部插入，头部删除
		 */
		this.dataQueue = new int[1000];
		this.maxQueue = new int[1000];
	}

	public int max_value() {
		if (maxHead == maxTail)
			return -1;
		return maxQueue[maxHead];
	}

	public void push_back(int value) {
		while (maxHead != maxTail && maxQueue[maxTail -1] < value)
			maxTail--;

		maxQueue[maxTail++] = value;
		dataQueue[dataTail++] = value;
	}

	public int pop_front() {
		int res = dataQueue[dataHead++];
		if (res == maxQueue[maxHead])
			maxHead++;

		return res;
	}

}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
