package com.thl.string;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 思路一：
 *
 */
public class Num_14 {
	public static void main(String[] args) {
		Num_14 test = new Num_14();
		String[] strings = new String[]{"dog","racecar","car"};
		System.out.println(test.longestCommonPrefix2(strings));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		String prefix = strs[0];
		for (int i = 0; i < strs.length; i++) {
			while (strs[i].indexOf(prefix, 0) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if (prefix.isEmpty()) return "";
			}
		}

		return prefix;
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";

		int prefixLen = 1;
		String prefix = "";
		for (int i = 0; i < strs[0].length(); i++) {
			prefix = strs[0].substring(0, 0 + prefixLen);
			for (String s : strs) {
				if (s.indexOf(prefix) != 0) {
					if ("".equals(prefix))
						return "";
					else return prefix.substring(0, prefix.length()-1);
				}
			}

			prefixLen++;
		}

		return prefix;

	}
}
