package com.thl.string.Medium;

public class Num_01_05 {
	public static void main(String[] args) {
		Num_01_05 test = new Num_01_05();
		System.out.println(test.oneEditAway("", "a"));


	}


	public boolean oneEditAway(String first, String second) {
		if (first.equals(second))
			return true;

		if (first.length() < second.length()) {
			String temp = first;
			first = second;
			second =temp;
		}

		int len1 = first.length();
		int len2 = second.length();
		//如果两者长度相同，可能发生了更新
		if (len2 == 0 && len1 == len2+1)
			return true;

		if (first.length() == second.length()) {
			for (int i = 0; i < len1; i++) {
				if (first.charAt(i) != second.charAt(i))
					return first.substring(i+1).equals(second.substring(i+1));
			}
		} else {
			//如果长度不同，发生了删除或者替换
			for (int i = 0; i < len2; i++) {
				if (first.charAt(i) != second.charAt(i)) {
					return first.substring(i+1).equals(second.substring(i));
				}
			}

			if (len1 == len2+1)
				return true;
		}

		return false;
	}
}
