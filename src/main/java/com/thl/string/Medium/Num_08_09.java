package com.thl.string.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 分析：排列组合的场景可以使用回溯的算法思想
 */
public class Num_08_09 {
	public static void main(String[] args) {
		Num_08_09 test = new Num_08_09();
		List<String> strings = test.generateParenthesis(7);
		for (String s : strings)
			System.out.println(s);
	}
	public List<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList<>();
		if (n == 0)
			return ans;

		if (n == 1) {
			ans.add("()");
			return ans;
		}

		dfs(n,n,"", ans);
		return ans;
	}

	public void dfs(int left, int right, String temp, List<String> res) {
		if (left == right && left == 0) {
			res.add(temp);
			return;
		}

		if (left == right)
			dfs(left-1, right, temp+"(", res);
		else if (left == 0){
			dfs(left, right-1,temp+")", res);
		} else {
			dfs(left-1, right, temp+"(", res);
			dfs(left, right-1, temp+")", res);
		}
	}
}
