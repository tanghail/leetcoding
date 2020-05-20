package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。。
 *
 *
 *
 *
 */


public class Num_39 {
	public static void main(String[] args) {
		Num_39 test = new Num_39();
		int[] candidates = {2,3,5};
		List<List<Integer>> lists = test.combinationSum(candidates, 8);
		for (List<Integer> list : lists) {
			for (int a : list)
				System.out.print(a + " ");
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList();
		dfs(candidates, res, new ArrayList<Integer>(), target, 0, 0);
		return res;
	}

	public void dfs(int[] candidates, List<List<Integer>> res, ArrayList<Integer> temp, int target, int sum, int index) {
		if (index < 0 || index == candidates.length || sum > target)
			return;

		if (sum == target) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			temp.add(candidates[i]);
			dfs(candidates, res,temp , target, sum + candidates[i], i);
			temp.remove(temp.size()-1);
		}
	}

}
