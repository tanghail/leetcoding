package com.thl.backTrack;

/**
 *
 * 求一个数组的众数
 *
 */


public class MajorityEle {
	public static void main(String[] args) {
		int[] arr = {3,1,3,};
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		int candidate = nums[0];
		for (int value : nums) {
			if (count == 0)
				candidate = value;
			count += (candidate == value)? 1 : -1;
		}

		return candidate;
	}
}
