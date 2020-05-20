package com.thl.dynamicProgramming;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 思路一：采用动态规划的算法思想，dp[i]表示到到下标为i的位置的最小步骤数，这里有一个细节，可以到跳到i位置的索引点由多个，
 * 		我们每次选择的都是索引点最小的值。意味着可以跳的更远
 */

public class Num_45 {
	public static void main(String[] args) {
		Num_45 test = new Num_45();
		int[] nums = {2,3,1,1,4};
		System.out.println(test.jump(nums));

	}


	public int jump(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		int index = 0;
		for (int i = 1; i < len; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = index; j <= i-1; j++) {
				if (nums[j] >= i-j ) {
					if (min > dp[j]+1) {
						min = dp[j] + 1;
						//下次开始的地方
						index = j;
						break;
					}
				}
			}

			dp[i] = min;
		}

		return dp[len-1] == Integer.MAX_VALUE ? -1 : dp[len-1];
	}
}
