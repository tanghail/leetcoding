package com.thl.huawei;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		System.out.println(getMin("bacaa", 2));
//		Scanner input = new Scanner(System.in);
//		while (input.hasNext()) {
//			String line = input.nextLine();
//			int k = Integer.parseInt(input.nextLine());
//			System.out.println(getMin(line, k));
//		}

	}


	public static String getMin(String str, int k) {
		int hasRemoveCount = 0;
		char[] chars = str.toCharArray();
		int len = chars.length;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < len-1; i++) {
			if (hasRemoveCount == k)
				break;
			if (chars[i] > chars[i+1]) {
				chars[i] = 'A';
				hasRemoveCount++;
			}
		}

		for (char c : chars) {
			if (c != 'A')
				ans.append(c);
		}

//		ans.delete(ans.length()-(k-))
		return ans.substring(0, ans.length()-(k-hasRemoveCount));




//		while (hasRemoveCount < k && cur <= str.length()-2) {
//			if (str.charAt(cur) > str.charAt(cur+1)) {
//				str = str.substring(0,cur) + str.substring(cur+1);
//				hasRemoveCount++;
//			} else cur++;
//
//
//		}
	}
}
