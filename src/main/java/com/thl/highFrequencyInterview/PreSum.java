package com.thl.highFrequencyInterview;

import java.util.HashMap;

/**
 * 前缀和问题：可用于解决数组区间的问题, 统计数组前缀和的问题
 * 因此对于具体情境算法问题的求解，需要对问题进行抽象或者转换成算法的模型，转换成熟悉的算法问题求解，这是算法问题最复杂的部分
 *
 * 题型：查找一个数组中子数组之和等于K的子数组的个数
 *
 * 思路一：暴力破解法
 *
 * 思路二：前缀和法，通过前缀和数组保存前n个元素的和
 *
 * 思路三：通过hash表保存前n个元素的和
 *
 * 对于算法思想应该通过题型来记忆，根据题型判断来找到应该使用的算法，例如看到数据区间问题就联想到前缀和算法思想
 */

public class PreSum {
	public static void main(String[] args) {
		System.out.println((char)('c' ^ ' '));

	}

	/**
	 * 思路二实现
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subArraySum(int[] nums, int k) {
		int len = nums.length;
		if (nums.length == 0)
			return 0;

		int[] preSum = new int[len+1];
		preSum[0] = 0;
		for (int i = 0; i < len; i++) {
			preSum[i+1] = preSum[i] + nums[i]; //preSum中preSum[i]表示nums[0..i-1]元素之和
		}

		int count = 0;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (preSum[j] == preSum[i] - k)
					count++;
			}
		}

		return count;
	}

	/**
	 * 思路三实现
	 * 思路二中需要通过O(n*n)的时间复杂度遍历preSum表找到子数组和为K，分析思路二，第42行代码的含义是找到preSum中是否有前缀和
	 * 为（K减去当前前缀和），因此可以通过hashMap的方式保存每一个前缀和，hashmap可以在O（1）的时间复杂度内查询，因此可以将时间复杂度
	 * 降到O(n)
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subArraySum2(int[] nums, int k) {
		int len = nums.length;
		if (len == 0)
			return 0;

		HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		preSum.put(0, 1);  //考虑从0开始的数组
		int sum = 0;
		int subSum = 0;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			subSum = sum - k;
			if (preSum.containsKey(subSum))
				ans += preSum.get(subSum);

			preSum.put(subSum, preSum.getOrDefault(subSum, 0) + 1);

		}

		return ans;
	}

}
