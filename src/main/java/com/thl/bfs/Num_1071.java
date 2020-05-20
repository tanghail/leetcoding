package com.thl.bfs;

import java.util.HashMap;
import java.util.Stack;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 思路一：枚举法
 * X（目标字符串）的长度必须是S和T字符串长度的公约数，因此可以先找到这个约数，然后再拼接字符串，若果能拼接成功即得到目标结果
 *
 */

public class Num_1071 {

	public static void main(String[] args) {
		Num_1071 test = new Num_1071();
		System.out.println(test.gcdOfStrings("ABCABC", "ABC"));

		Stack<Integer> stack = new Stack<>();

	}

	public String gcdOfStrings(String str1, String str2) {
		if (str1 == null || str2 == null)
			return null;

		int len1 = str1.length();
		int len2 = str2.length();
		String res;
		String minStr = str1.length() > str2.length()? str2 : str1;
		for (int i = minStr.length(); i >= 1; i--) {
			if (len1 % i == 0 && len2 % i == 0) {
				// 从大到小找到公约数
				res = minStr.substring(0, i);
				if (check(res, str1)&&check(res, str2))
					return res;
			}
		}

		return null;
	}

	public boolean check(String x, String baseStr) {
		int count = (int) (baseStr.length()/x.length());
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < count; i++) {
			res.append(x);
		}

		return baseStr.equals(res.toString());
	}
}
