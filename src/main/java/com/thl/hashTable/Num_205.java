package com.thl.hashTable;

import java.util.HashMap;

/**
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 方法一：常规方法：通过hashtable保存s中每个字符到t中每个字符的映射，因为可能存在s中不同字符映射到通过一个字符的情况，因此需要考虑这种情况、
 *       参考： https://leetcode-cn.com/problems/isomorphic-strings/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
 *
 * 方法二：将s和t生成第三方的格式，判断s和t第三方的格式是否相同
 * 		 将每个字符映射到自己的下标，如果已经发生过映射就不再映射
 *
 *
 */


public class Num_205 {
	public static void main(String[] args) {
		Num_205 test = new Num_205();
		boolean res = test.isIsomorphic("ab", "ca");
		System.out.println(res);
	}


	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (! map.keySet().contains(s.charAt(i))) {
				if (map.containsValue(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
			} else {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
		}

		return true;
	}

	public String isIsomorphic(String s) {
		int[] map = new int[128];
		StringBuilder sb = new StringBuilder();
		int len  = s.length();
		for (int i = 0; i < len; i++) {
			if (map[s.charAt(i)] == 0) {
				map[s.charAt(i)] = i+1;
			}
			sb.append(map[s.charAt(i)]);
		}

		return sb.toString();
	}

}
