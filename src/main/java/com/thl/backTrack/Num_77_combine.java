package com.thl.backTrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 思路一：回溯法（）
 */


public class Num_77_combine {
	public static void main(String[] args) {
		Num_77_combine test = new Num_77_combine();
		List<List<Integer>> combine = test.combine(4, 2);
		for (List<Integer> list : combine) {
			for (int a : list)
				System.out.print(a + " ");
			System.out.println();
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i+1;
		}
		dfs(nums, res, temp, k, 0);
		return res;
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int k, int start) {
		if (temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			dfs(nums, res, temp, k, i + 1);
			temp.remove(temp.size()-1);
		}
	}
}
