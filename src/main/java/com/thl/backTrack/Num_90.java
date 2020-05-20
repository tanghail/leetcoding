package com.thl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 思路一：参考：https://leetcode-cn.com/problems/subsets-ii/solution/czhong-fu-yuan-su-chu-li-bu-tong-shu-liang-de-zhon/
 * 对于重复的数字，每次按重复元素的数量选择且只选择一次，此题和num 78类似，只是第78题中元素各不相同
 *
 */


public class Num_90 {
	public static void main(String[] args) {
		Num_90 test = new Num_90();
		int[] nums = {1,2,2};
		List<List<Integer>> lists = test.subsetsWithDup(nums);
		for (List<Integer> list : lists) {
			for (int value : list)
				System.out.print(value + " ");
			System.out.println();
		}

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		//统计nums中每个元素的个数
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());  //插入一个空元素
		for (int value : nums) {
			if (map.keySet().contains(value)) {
				map.put(value, map.get(value)+1);
			} else map.put(value, 1);
		}

		for (int i = 0; i < nums.length;) {
			if (map.get(nums[i]) == 1) {
				for (List<Integer> list : result){
					ArrayList<Integer> temp = new ArrayList<Integer>(list);
					temp.add(nums[i]);
					result.add(temp);

				}
				i++;
			} else {
				int dupCount = map.get(nums[i]);
				for (int j = 1; j <= dupCount; i++) {
					for (List<Integer> list : result){
						ArrayList<Integer> temp = new ArrayList<Integer>(list);
						for (int k = 1; k<= i; j++)
							temp.add(nums[i]);
						result.add(temp);
					}
				}

				i += dupCount;
			}
		}

		return result;
	}

}
