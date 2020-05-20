package com.thl.hashTable;

import java.util.HashSet;

/**
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 方法一：维持一个大小为k的滑动窗口，通过hashset来实现（可以实现随机读取），当当前的数字存在于hashset中时
 * 		  返回true，否则移除当前窗口最左边的元素（相当于窗口向右移动一个位置）
 *
 */


public class Num_219 {
	public static void main(String[] args) {
		Num_219 test = new Num_219();
		int[] nums = {1,2,3,2,2,3};
		System.out.println(test.containsNearbyDuplicate(nums, 3));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (set.contains(nums[i]))
				return true;

			set.add(nums[i]);
			if (set.size() > k)
				set.remove(nums[i-k]);
		}
		return false;
	}
}
