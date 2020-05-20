package com.thl.dynamicProgramming;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 */

public class Num_55 {
	public static void main(String[] args) {


	}
	public boolean canJump(int[] nums) {
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (end >= nums.length-1)
				return true;

			end = Math.max(end, i+nums[i]);
			if (i == end)
				return false;
		}

		return false;
	}

	//从后往前遍历
	public boolean canJump2(int[] nums) {
		int len = nums.length;
		int lastIndex = len-1;
		for (int i = len - 2; i >= 0; i--) {
			if (i+nums[i] >= lastIndex)
				lastIndex = i;
		}

		return lastIndex == 0;
	}

	//从前往后遍历
	public boolean canJump3(int[] nums) {
		int len = nums.length;
		int end = 0;
		for (int i = 0; i < len; i++) {
			if (i > end)
				return false;

			end = Math.max(end, i+nums[i]);
			if (end == len-1)
				return true;
		}

		return false;
	}
}
