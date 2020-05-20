package com.thl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 *
 *
 *
 */


public class Num_40 {
	public static void main(String[] args) {
		Num_40 test = new Num_40();
		int[] candidates = {2,5,2,1,2};
		List<List<Integer>> lists = test.combinationSum(candidates, 5);
		for (List<Integer> list : lists) {
			for (int a : list)
				System.out.print(a + " ");
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList();
		Arrays.sort(candidates);
		dfs(candidates, res, new ArrayList<Integer>(), target, 0, 0);
		return res;
	}

	public void dfs(int[] candidates, List<List<Integer>> res, ArrayList<Integer> temp, int target, int sum, int index) {
		if (sum == target) {
			if (!res.contains(temp))
				res.add(new ArrayList<Integer>(temp));
			return;
		}

		if (index < 0 || index == candidates.length || sum > target) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			temp.add(candidates[i]);
			dfs(candidates, res,temp , target, sum + candidates[i], i+1);
			temp.remove(temp.size()-1);
		}
	}

}
