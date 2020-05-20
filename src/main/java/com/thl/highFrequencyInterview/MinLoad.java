package com.thl.highFrequencyInterview;

import java.util.Hashtable;

/**
 * 传送带上的第i个包裹的重量为weights[i]，每一天，我么都会按照给出的重量的顺讯往传送带上装载包裹，我们装载的重量不会超过船的最大装载重量
 * 返回D天内将传送带上的货物送达传的最低装载重量
 *
 * 分析：
 *
 */

public class MinLoad {
	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		MinLoad test = new MinLoad();
		System.out.println(test.getMinLoad(weights, 5));
		Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();

	}

	public int getMinLoad(int[] weights, int days){
		int min = getMax(weights);
		int max = sum(weights);
		while (min < max) {
			int mid = (min + max) / 2;
			if (canLoad(mid, weights, days)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		return min;
	}


	public boolean canLoad (int load, int[] weights, int days) {
		int sum = 0;
		int count = 0;
		for (int weight : weights) {
			if (sum + weight > load) {
				count ++;
				sum = weight;
			} else if (sum + weight == load){
				count++;
				sum = 0;
			} else
				sum += weight;
		}

		if (sum > 0)
			count++;

		return count <= days;
	}

	public int getMax(int[] nums) {
		int len = nums.length;
		int max = nums[0];
		for (int value : nums)
			if (value > max) {
				max = value;
			}
		return max;
	}

	public int sum(int[] weights) {
		int sum = 0;
		for (int value : weights)
			sum += value;

		return sum;
	}

}
