package com.thl.backTrack;

/**
 *给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]
 *
 */


public class Num_60 {
	public static void main(String[] args) {
		Num_60 test = new Num_60();
		String permutation = test.getPermutation(4, 9);
		System.out.println(permutation);

	}

	public String getPermutation(int n, int k) {
		int count = 1;
		int[] values = new int[n];
		if (k <= 0 || k > factorial(n))
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			values[i] = i+1;
		}

		if (k == count) {
			for (int i = 0; i < n; i++) {
				sb.append(i+1);
			}
			sb.append("\"");
			return sb.toString();
		}

		int j = n -1;
		int cur = 0;
		while (true) {
			j = n-1;
			while (j > 0 && values[j-1] > values[j])
				j--;
			if (j == 0)  //已经达到最后一个排列
				return null;

			cur = j-1;
			while ( j < n && values[cur] < values[j])
				j++;

			swap(values, cur, j-1);
			reverse(values,cur+1);

			if (count++ == k-1) {
				for (int i = 0; i < n; i++) {
					sb.append(values[i]);
				}
				sb.append("\"");
				return sb.toString();
			}

		}
	}

	public void swap( int[] values, int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	public void reverse(int[] value, int pos) {
		for (int i = pos, j = value.length -1; i < j;)
			swap(value, i++, j--);
	}

	public int factorial(int n) {
		int sum = 1;
		while (n>0)
			sum *= n--;
		return sum;
	}


}
