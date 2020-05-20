package com.thl.dynamicProgramming;


import java.util.ArrayList;

/**
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 *
 * 思路一：
 * 	暴力破解，采用746的方式，循环执行多次
 *
 * 思路二：采用数组加链表的方式，遍历S字符串时，每一个单词此时已经匹配到的位置，如果一个单词匹配结束，则匹配的单词数量加一
 *
 */

public class Num_792 {
	public int numMatchingSubseq(String S, String[] words) {
		int ans = 0;
		ArrayList<Node>[] arr = new ArrayList[26];
//		for (String word : words)
//			arr[word.charAt(0)-'a'] = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			arr[i] = new ArrayList<>();

		for (String word : words)
			arr[word.charAt(0)-'a'].add(new Node(word, 0));

		char[] chars = S.toCharArray();
		for (char c : chars) {
			ArrayList<Node> oldList = arr[c - 'a'];
			arr[c - 'a'] = new ArrayList<Node>();
			for (Node node : oldList) {
				node.index++;
				if (node.index == node.word.length())
					ans++;
				else {
					arr[node.word.charAt(node.index)-'a'].add(node);
				}
			}

			oldList.clear();
		}

		return ans;
	}
}

class Node {

	public Node(String word, int index) {
		this.word = word;
		this.index = index;
	}

	String word;
	int index;
}
