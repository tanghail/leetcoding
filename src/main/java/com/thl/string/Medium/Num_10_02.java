package com.thl.string.Medium;


import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 */
public class Num_10_02 {
	public static void main(String[] args) {
		Num_10_02 test = new Num_10_02();
		String string = test.unifyString("acbesgf");
		System.out.println(string);


	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		if (strs.length == 0)
			return ans;

		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String unifyString = unifyString(s);
			if (!map.containsKey(unifyString)) {
				map.put(unifyString, new ArrayList<String>());
			}

			map.get(unifyString).add(s);
		}

		Set<Map.Entry<String, List<String>>> entries = map.entrySet();
		for (Map.Entry<String, List<String>> entry : entries)
			ans.add(entry.getValue());
		return ans;

	}

	public String unifyString(String value) {
		//快排
		char[] chars = value.toCharArray();
		quickSort(0, chars.length-1, chars);
		return String.valueOf(chars);
	}

	private void quickSort(int low, int high, char[] datas) {
		int index = partition(low, high, datas);
		if (index >= 0){
			quickSort(low, index-1,datas);
			quickSort(index+1, high,datas);
		}
	}

	private int partition(int low, int high, char[] values) {
		if (low < high) {
			int i = low-1;
			int cur = low;
			char cursor = values[high];
			while (cur < high) {
				if (values[cur] < cursor) {
					i++;
					char temp = values[cur];
					values[cur] = values[i];
					values[i] = temp;
				}
				cur++;
			}

			char temp = values[i+1];
			values[i+1] = cursor;
			values[high] = temp;
			return i+1;
		}

		return -1;
	}
}
