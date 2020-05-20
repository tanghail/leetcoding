package com.thl.juc;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MaxWindows {
	public static void main(String[] args) {
		int[] arr = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> integers = maxInWindows(arr, 3);
		for (int a : integers)
			System.out.println(a);

	}

	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		if (num == null || num.length == 0)
			return null;

		if (size < 0 || num.length < size)
			return null;

		int len = num.length;
		int max = num[0];
		int pos = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		max = getMax(num, 0, size-1, pos);
		result.add(max);

		for (int i = size; i < len; i++) {
			if (pos < i - size+1) {
				pos = i - size+1;
				max = getMax(num, pos, i, pos);
			}
			if (max < num[i]) {
				max = num[i];
				pos = i;
			}
			result.add(max);
		}

		return result;
	}

	public static int getMax(int[] num, int start, int end, int pos){
		int max = num[start];
		for (int i = start; i <=end; i++ ) {
			if (max < num[i]) {
				max = num[i];
				pos = i;
			}
		}
		return max;
	}
}
