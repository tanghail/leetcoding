package com.thl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列
 *
 * 思路：采用回溯法，每当选好一个数之后，把这个数放到数组的最后的位置，已经排好的数字个数加一，接下来从待排的数组选择
 * 		递归结束后，恢复原状，重新选择
 */


public class Num_47 {
	public static void main(String[] args) {
		Num_47 test = new Num_47();
		int[] nums = {1,2,3};
		List<List<Integer>> lists = test.permute(nums);
		for (List<Integer> list : lists) {
			for (int a : list)
				System.out.print(a + " ");
			System.out.println();
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, res, temp, 0);
		return res;
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int count){
		if (temp.size() == nums.length) {
			if (!res.contains(temp))
				res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length-count; i++) {
			temp.add(nums[i]);
			swap(nums, i, nums.length-count-1);
			dfs(nums, res, temp, count + 1);
			temp.remove(temp.size()-1);
			reswap(nums, i,nums.length-count-1);

		}

	}

	public void swap (int[] nums, int pos, int last) {
		int temp = nums[pos];
		for (int i = pos; i < last; i++)
			nums[i] = nums[i+1];
		nums[last] = temp;
	}

	public void reswap (int[] nums, int pos, int last) {
		int temp = nums[last];
		for (int i = last; i > pos; i--)
			nums[i] = nums[i-1];
		nums[pos] = temp;
	}

}
