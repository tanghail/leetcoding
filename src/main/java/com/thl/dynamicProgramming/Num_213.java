package com.thl.dynamicProgramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的
 * 。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *  示例 1:
 *  输入: [2,3,2]
 *  输出: 3
 *  解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *  示例 2:
 *  输入: [1,2,3,1]
 *  输出: 4
 *  解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *       偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 思路一：动态规划
 *  状态转移方程：house[i] = Math.max(house[i-2]+nums[i], house[i-1])
 *
 */

public class Num_213 {
	public static void main(String[] args) {
		Num_213 test = new Num_213();
		int[] nums = {2,3,2};
		System.out.println(test.rob(nums));
	}


	/**
	 * 分析：此题和198题的区别是房子之间形成了环，意味着抢劫了第一家就不能抢劫最后一家，因此要分开讨论
	 * 		思路和198题类似
	 *
	 *
	 *
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);


		//当偷窃第一间房子时
		int a = nums[0];
		int b = Math.max(a, nums[1]);
		for (int i = 2; i < nums.length; i++) {
			if (i == nums.length-1)
				break;

			int temp = Math.max(a+nums[i], b);
			a = b;
			b = temp;
		}

		//当不偷窃第一栋房子时
		int c = nums[1];
		int d = Math.max(c, nums[2]);
		for (int i = 3; i < nums.length; i++) {
			int temp = Math.max(c+nums[i], d);
			c = d;
			d = temp;
		}

		return Math.max(b,d);
	}

}
