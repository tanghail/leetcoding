package com.thl.string;

/**
 * 实现strStr
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Num_28 {
	public static void main(String[] args) {
		Num_28 test = new Num_28();
		System.out.println(test.strStr("hello", ""));
	}
	public int strStr(String haystack, String needle) {
		if ("".equals(needle) && "".equals(haystack))
			return 0;

		if ("".equals(haystack))
			return 0;

		int h = haystack.length();
		int n = needle.length();
		for (int i = 0; i <= h - n; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				if (haystack.substring(i, i+n).equals(needle))
					return i;
			}
		}

		return -1;
	}
}
