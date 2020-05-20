package com.thl.string.Medium;

import java.util.Map;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 *
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 */
public class Num_16_18 {

	public boolean patternMatching(String pattern, String value) {
		if ("a".equals(pattern) || "b".equals(pattern) || "ab".equals(pattern))
			return true;




		return false;
	}

	public boolean isMatched(String pattern, String subStr, String a, String b) {
		if (subStr == null)
			return true;

		char firstChar = pattern.charAt(0);
		int i = 0;
		while (i < pattern.length() && pattern.charAt(i) == firstChar) {
			i++;
		}

		switch (firstChar) {
			case 'a':
				if (a != null) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < i; j++ )
						sb.append(a);
					if (!subStr.substring(0, i*a.length()).equals(sb.toString()))
						return false;
				}else {

				}
			case 'b':
				if (b != null) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < i; j++ )
						sb.append(a);
					if (!subStr.substring(0, i*b.length()).equals(sb.toString()))
						return false;
				} else {


				}
		}

		return false;

	}

}
