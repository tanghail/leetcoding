package com.thl.string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Num_67 {
	public static void main(String[] args) {
		Num_67 test = new Num_67();
		System.out.println(test.addBinary("100", "110010"));


	}

	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		int overFlow = 0;
		StringBuilder sb = new StringBuilder();
		int j = a.length() -1;
		for (int i = b.length()-1; i >= 0; i--, j--) {
			int value = a.charAt(j) + b.charAt(i) -96 + overFlow;
			sb.append(value % 2);
			overFlow = value / 2;
		}


		for (; j >= 0; j--) {
			int value = a.charAt(j) - 48 + overFlow;
			sb.append(value % 2);
			overFlow = value / 2;
		}

		if (overFlow > 0)
		  	sb.append(overFlow);

		return sb.reverse().toString();
	}
}
