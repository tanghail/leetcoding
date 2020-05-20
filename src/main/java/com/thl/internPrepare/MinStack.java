package com.thl.internPrepare;

import java.util.*;

public class MinStack {
	private List<Integer> valueQueue;
	private ArrayDeque<Integer> minQueue;

	public MinStack() {
		valueQueue = new ArrayList<>();
		minQueue = new ArrayDeque<>();
	}

	public Integer getMin(){
		if (!minQueue.isEmpty())
			return minQueue.getFirst();

		return null;
	}


	public void push(int value) {
		if (valueQueue.isEmpty()) {
			valueQueue.add(value);
			minQueue.add(value);
			return;
		}

		valueQueue.add(value);
		int size = valueQueue.size()-1;
		while (size > 0) {
			int temp = valueQueue.get(size-1);
			valueQueue.set(size-1, valueQueue.get(size));
			valueQueue.set(size, temp);
			size--;
		}

		while (!minQueue.isEmpty() && minQueue.getLast() > value) {
			minQueue.removeLast();
		}

		minQueue.addLast(value);
	}

	public Integer top() {
		if (valueQueue.isEmpty())
			return null;

		return valueQueue.get(valueQueue.size()-1);
	}

	public void pop() {
		if (valueQueue.isEmpty())
			return;

		int temp = valueQueue.get(valueQueue.size()-1);
		valueQueue.remove(valueQueue.size()-1);
		if (temp == minQueue.getFirst())
			minQueue.removeFirst();
	}
}
