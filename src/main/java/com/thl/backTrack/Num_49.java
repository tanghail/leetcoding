package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 */


public class Num_49 {
	public static void main(String[] args) {
		Num_49 test = new Num_49();
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
		dfs(nums, res, temp, 0);
		return res;
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int count){
		if (temp.size() == nums.length) {
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
