package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 方案1；递归加回溯
 *
 * 方案2：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/参考思路
 * 将每次添加进来的新的元素与已经添加的元素重新构成新的元素
 *
 * 方案三：掩码法，将每一个可能的组合通过一个掩码来表示
 * 如何生成一个长度为n，从0000...0～1111...1的掩码序列
 *
 * 代码片段1：
 * int nbite = 1<<n
 * for(int i = 0; Math.pow(2,n); i++)
 * 		Integer.toBinaryString(i | nbite).substring(1);  //为了加上左边的0，在最左边新加了一位1
 *
 * 代码片段2：
 * for（int i = Math.pow(2,n); i < Math.pow(2,n+1); i++）
 * 		Integer.toBinaryString(i).substring(1);
 *
 */

public class Num_78 {
	public static void main(String[] args) {
		Num_78 test = new Num_78();
		int[] nums = {1,2,3,4};
		List<List<Integer>> lists = test.subsets3(nums);
//		for (List<Integer> list : lists) {
//			for (int a : list)
//				System.out.print(a + " ");
//			System.out.println();
//		}

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		res.add(new ArrayList<Integer>(temp));
		dfs(nums, res, temp);
		return res;
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp) {
		for (int size = 1; size <= nums.length; size++) {
			dfs(nums, res, temp,0, size);
		}
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int start, int len) {
		if (temp.size() == len) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, res, temp, i + 1, len);
			temp.remove(temp.size()-1);
		}

	}


	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		output.add(new ArrayList<Integer>());

		for (int t : nums) {
			List<List<Integer>> newSubsets = new ArrayList();
			for (List<Integer> curr : output) {
				ArrayList<Integer> temp = new ArrayList<Integer>(curr);
				temp.add(t);
				newSubsets.add(temp);
			}
			for (List<Integer> curr : newSubsets) {
				output.add(curr);
			}
		}
		return output;
	}

	public List<List<Integer>> subsets3(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		int n = nums.length;

		for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
			// generate bitmask, from 0..00 to 1..11
			String bitmask = Integer.toBinaryString(i).substring(1);
			System.out.println(bitmask);

			// append subset corresponding to that bitmask
			List<Integer> curr = new ArrayList();
			for (int j = 0; j < n; ++j) {
				if (bitmask.charAt(j) == '1') curr.add(nums[j]);
			}
			output.add(curr);
		}
		return output;
	}

}
