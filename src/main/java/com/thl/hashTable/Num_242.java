package com.thl.hashTable;

import java.util.ArrayDeque;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 字母异位词：字母均相同但位置可能不同
 *
 * 方法一：排序法
 *
 * 方法二：以字母为索引设置标志位
 *
 *
 */


public class Num_242 {
	public static void main(String[] args) {
		ArrayDeque<Integer> integers = new ArrayDeque<Integer>();
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] chars = new int[26];
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		for (int value : chars) {
			if (value != 0)
				return false;
		}

		return true;
	}

}
