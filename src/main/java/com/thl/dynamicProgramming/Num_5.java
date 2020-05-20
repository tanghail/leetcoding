package com.thl.dynamicProgramming;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 思路一：动态规划算法
 * 	1、状态保存变量dp[i][j]：表示在字符串下标i～j的子字符串是否是子回文子串，是则用true表示，否则false
 * 	2、初始化为0
 * 	3、状态转移方程:dp[i][j] = (dp[i+1][j-1] && (s.charAt(i) == s.charAt(j)))
 * 	4、考虑边界情况
 * 	5、自底向下的使用dp算法要求重用之前的计算结果，因此需要考虑如何重用之前的计算结果，根据回文串的长度递增方式
 *
 * 	思路二：暴力解法O(n3)
 *
 * 	思路三：将字符串倒转
 */

public class Num_5 {
	public static void main(String[] args) {
		Num_5 test = new Num_5();
		System.out.println(test.longestPalindrome("ccc"));
	}


	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		int left = 0;
		int right = 0;
		int max = 1;
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = 0; i < len-1; i++) {
			dp[i][i] = 1;
			if (s.charAt(i) == s.charAt(i+1)){
				dp[i][i+1] = 1;
				left = i;
				right = i+1;
				max = 2;
			}
		}

		dp[len-1][len-1] = 1;
		for (int size = 3; size <= len; size++) {
			for (int i = 0; i <= len-size; i++) {
				if (dp[i+1][i+size-2] == 1 && s.charAt(i) == s.charAt(i+size-1))
					dp[i][i+size-1] = 1;

				if (dp[i][i+size-1] == 1 && size > max) {
					max = size;
					left = i;
					right = i+size-1;
				}



			}

		}

//		for (int i = len -2; i >= 0; i--) {
//			for (int j = i+1; j < len; j++) {
//				if (j != i+1) {
//					if (dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j))
//						dp[i][j] = 1;
//				}
//
//				if (dp[i][j] == 1 && max < j-i+1) {
//					max = j-i+1;
//					left = i;
//					right = j;
//				}
//			}
//		}


		System.out.println(left + " " + right);
		return s.substring(left, right+1);


	}
}
