package com.thl.highFrequencyInterview;

import java.util.HashMap;

/**
 * 查找缺失的元素和重复的元素
 *
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * 分析：
 * 	数组的元素和数组的下标存在着对应关系，因此重复的元素可以两次被对应到同一个下标的元素，而缺失的元素对应的下标没有被索引过
 * 	因此通过正负性标记来判断是否已经被索引过
 *
 * 	方法一：hashmap保存数组中元素和对应次数
 *
 */

public class Num_645 {
	public static void main(String[] args) {
		Num_645 test = new Num_645();
		int[] nums = {2,3,2};
		int[] errorNums = test.findErrorNums(nums);
		System.out.println(errorNums[0]);
		System.out.println(errorNums[1]);


	}

	public int[] findErrorNums(int[] nums) {
		int len = nums.length;
		int[] ans = new int[2];
		for (int i = 0; i < len; i++) {
			if (nums[Math.abs(nums[i]) - 1] < 0) {
				ans[0] = Math.abs(nums[i]);
				continue;
			}

			nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
		}

		int index = 0;
		for (int v : nums) {
			if (v > 0) {
				ans[1] = index+1;
				break;
			}
			index++;
		}

		return ans;
	}
}
