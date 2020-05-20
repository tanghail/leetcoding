package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
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
 * 括号生成的特点：
 * 		1、第一个括号必须是左括号
 * 		2、当左括号数量小于右括号时，添加左括号
 * 	注意：在括号序列是否有效类似的题目中，可以通过左括号的数量是否小于0 来判断是否有效
 *
 * 	思路1：回溯法
 */


public class Num_22 {
	public static void main(String[] args) {
		Num_22 test = new Num_22();
		List<String> strings = test.generateParenthesis(2);
		for (String s : strings)
			System.out.println(s);
	}

	public List<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		generateParenthesis(res, "(", n-1, n);
		return res;
	}

	public void generateParenthesis(List<String> res, String temp, int left, int right) {
		if (left == 0 && right == 0) {
			res.add(temp);
			return;
		}

		if (left == right)
			generateParenthesis(res, temp + "(", left - 1, right);

		if (left == 0 && right > 0)
			generateParenthesis(res, temp + ")", left , right-1);

		if (left > 0 && right > left) {
			generateParenthesis(res, temp + "(", left - 1, right);
			generateParenthesis(res, temp + ")", left , right - 1);
		}

		if (left > right)
			generateParenthesis(res, temp + "(", left - 1, right);

	}

}
