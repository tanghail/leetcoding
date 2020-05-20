package com.thl.huawei;

import java.util.HashSet;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			String s = removeDupChar(line);
			System.out.println(s);
		}

	}

	public static String removeDupChar(String str) {
		HashSet<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (!set.contains(str.charAt(i))) {
				set.add(str.charAt(i));
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}
}
