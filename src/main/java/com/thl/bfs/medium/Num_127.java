package com.thl.bfs.medium;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 思路一：将每一个word转成第三种中间的格式，放在hashmap中
 *
 * 思路二：双端广度优先搜索
 *
 *
 */
public class Num_127 {
	public static void main(String[] args) {
		Num_127 test = new Num_127();
		ArrayList<String> arr = new ArrayList<>();
		arr.add("hot");
		arr.add("dot");
		arr.add("dog");
		arr.add("lot");
		arr.add("log");
		arr.add("cog");
		System.out.println(test.ladderLength("hit", "cog", arr));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.length() != endWord.length()  || !wordList.contains(endWord))
			return 0;

		HashMap<String, List<String>> map = transferTo(wordList);
		return dfs(beginWord, endWord,1, wordList, map);

	}

	public int dfs(String beginWord, String endWord, int size, List<String> wordList, HashMap<String, List<String>> map) {
		if (size > wordList.size())
			return 0;

		int len = beginWord.length();
		int min = 0;
		for (int i = 0; i < len; i++) {
			String newWord = beginWord.substring(0, i) + "*" + beginWord.substring(i+1);
			if ( !map.containsKey(newWord)) {
				continue;
			}

			List<String> nextwords = map.get(newWord);
			for (String nextword : nextwords) {
				if (nextword == endWord)
					return size+1;

				int dfs = dfs(nextword, endWord, size + 1, wordList, map);
				if (dfs > 0) {
					if (min == 0)
						min = dfs;
					else
						min = Math.min(min, dfs);
				}

			}
		}

		return min;
	}

	public HashMap<String, List<String>> transferTo(List<String> wordList) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String word : wordList) {
			int len = word.length();
			for (int i = 0; i < len; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1);
				if (! map.containsKey(newWord)) {
					map.put(newWord, new ArrayList<>());
				}

				map.get(newWord).add(word);
			}
		}

		return map;
	}
}
