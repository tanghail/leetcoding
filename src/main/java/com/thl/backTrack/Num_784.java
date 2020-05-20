package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 *
 * 思路1：回溯法
 *
 * 思路2：n个字母字符，转成大小写的字符串，一共有2的n次方个不同的排列，因此根据美中情况中0和1的标记转成大小写（假设0是小写， 1是大写）
 * 思路3：如果遇到字母就复制成两份
 */


public class Num_784 {
	public static void main(String[] args) {
		Num_784 test = new Num_784();
		List<String> a1b3 = test.letterCasePermutation("a1b3AKl");
		for (String s : a1b3)
			System.out.println(s);
	}

	public List<String> letterCasePermutation(String S) {
		ArrayList<String> res = new ArrayList<String>();
		letterCasePermutation(S, res, "", 0);
		return res;
	}

	public void letterCasePermutation(String s, List<String> res, String temp, int index) {
		if (index == s.length()) {
			res.add(temp);
			return;
		}

		if ('a' <= s.charAt(index) && s.charAt(index) <= 'z') {
			letterCasePermutation(s, res, temp+ (char)(s.charAt(index) - 32), index + 1);
		}

		if ('A' <= s.charAt(index) && s.charAt(index) <= 'Z') {
			letterCasePermutation(s, res, temp+ (char)(s.charAt(index) + 32), index + 1);
		}

		letterCasePermutation(s, res, temp+ s.charAt(index) , index + 1);
	}
}
