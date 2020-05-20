package com.thl.string;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 *
 */
public class Num_58 {
	public static void main(String[] args) {
		Num_58 test = new Num_58();
		System.out.println(test.lengthOfLastWord("hello world"));
	}
	public int lengthOfLastWord(String s) {
		if (" ".equals(s) || "".equals(s))
			return 0;
		String[] words = s.split(" ");
		int len = words.length;
		for (int i = len-1; i >= 0; i++) {
			if (!"".equals(words[i]))
				return words[i].length();
		}

		return 0;
	}
}
