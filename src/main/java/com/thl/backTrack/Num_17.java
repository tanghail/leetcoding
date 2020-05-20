package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * 思路一：回溯法 (起手式之 res对象保存结果， temp参数表示回溯的载体， index指示当前的位置)
 *
 */


public class Num_17 {
	public static void main(String[] args) {
		Num_17 test = new Num_17();
		List<String> res = test.letterCombinations("273");
		for (String str : res) {
			System.out.println(str);
		}

	}

	public List<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return res;

		dfs(digits, res, "", 0);
		return res;
	}

	private char[][] chars = {{'a','b', 'c'},{'d','e', 'f'},{'g','h', 'i'},{'j','k', 'l'},{'m','n', 'o'},{'p','q', 'r','s'},{'t','u','v'},{'w','x','y','z'}};
	public void dfs(String digits, List<String> res, String temp, int index) {
		if (digits.length() == index) {
			res.add(temp);
			return;
		}

		int digit =  (int) digits.charAt(index)-48;
		int len = chars[digit-2].length;
		for (int i = 0; i < len; i++) {
			dfs(digits, res, temp + chars[digit - 2][i], index + 1);
		}
	}

}
