package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 此题使用回溯法：
 *
 */


public class PartitionPalinadrome {
	public static void main(String[] args) {
		String string = "aab";
		ArrayList<String> list = new ArrayList();
		List<List<String>> res = new ArrayList();
		partitionSub(string, res, list, 0);

		for (List<String> sub : res) {
			for (String str : sub) {
				System.out.print(str + "  ");
			}
			System.out.println();
		}

		System.out.println('A' - 'a');
	}

	public static void partitionSub(String str, List<List<String>> res, List<String> temp, int start) {
		if (start == str.length()) {
			res.add(new ArrayList<String>(temp));
			return;
		}

		for (int i = start; i < str.length(); i++) {
			String substring = str.substring(start, i + 1);
			if (isPalinadrome(substring)) {
				temp.add(substring);
				partitionSub(str, res, temp, i+1);
				temp.remove(temp.size()-1);
			}

		}

	}

	public static boolean isPalinadrome(String str){

		if (str == null) {
			return false;
		}

		if (str.length() == 1)
			return true;

		int len = str.length();
		int start = 0;
		int end = len -1;
		while (start < end) {
			if (str.charAt(start)  == str.charAt(end)
					|| (str.charAt(start)  - str.charAt(end)) == 32
					|| (str.charAt(start)  - str.charAt(end)) == -32) {
				start++;
				end--;
			} else
				return false;
		}

		return true;
	}
}
