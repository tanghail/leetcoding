package com.thl.huawei;

import java.util.HashSet;
import java.util.Scanner;

public class Test03 {
	private static int ans = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) {
				System.out.println(0);
			} else if (line.length() == 1) {
				System.out.println(1);
			} else {
				getcount(line);
				System.out.println(ans);
			}

			ans = 0;
		}


	}

	public static void getcount(String str) {
		if (str.length() == 0) {
//			System.out.println(0);
			ans++;
		}

		int len = str.length();
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < len; i++) {
			if (!hashSet.contains(str.charAt(i))) {
				String temp = str.substring(0,i) + str.substring(i+1);
				hashSet.add(str.charAt(i));
				getcount(temp);
			}
		}

	}

}
