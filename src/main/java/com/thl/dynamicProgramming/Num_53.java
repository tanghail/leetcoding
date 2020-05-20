package com.thl.dynamicProgramming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 思路一：贪心算法
 * 	每次选择前面字串和当前值之和发生增益的字串，即前面的字串是正数
 *
 * 思路二：动态规划算法
 * dp[i] = Math.max(dp[i]+nums[i], nums[i])
 *
 * 思路三：分治法
 */

public class Num_53 {
	private static int start = 0;
	private static int end = 0;

	public static void main(String[] args) {
		Num_53 test = new Num_53();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] nums = {-2,-7,-3,-4,-1,-2,-1,-5,-4};
		int ans = test.maxSubArray2(nums);
		System.out.println("from " + start + " to "+ end + " and  sum = " + ans);
	}

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int res = nums[0];
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}

			res = Math.max(sum, res);
		}

		return res;
	}

	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i-1]+nums[i] < nums[i]) {
				start = i;
				dp[i] = nums[i];
			} else dp[i] = dp[i-1]+nums[i];
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			if (max < dp[i]) {
				max =dp[i];
				end = i;
			}
		}

		return max;
	}

	/**
	 * 变式：返回最大和的连续子数组的下标
	 *
	 *
	 */
}
