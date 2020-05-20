package com.thl.backTrack;

/**
 *
 * 任意一个正整数生成对应的全排列序列
 *
 * 方法一：采用回溯法（可参考46、47题）
 *
 * 方法二：字典序法（可参考字典序的原理图：https://leetcode-cn.com/articles/next-permutation/）
 * 算法描述：每次从数组的最后一个元素向前遍历，找到第一个a[j-1] < a[j]的元素对，此时a[j]右边的元素是递减排列的，
 * 			将a[j-1]和a[j-1]右边大于a[j-1]的最小的元素交换位置，得到的就是当前序列的下一个序列。因此字典序法可解决
 * 			全排列和下一个排列的两种问题
 *
 *
 */


public class Num_60_1 {
	public static void main(String[] args) {
		Num_60_1 test = new Num_60_1();
		test.getPermutation(6);

	}

	public void getPermutation(int n) {
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			values[i] = i+1;
			System.out.print(i+1 + " ");
		}

		System.out.println();

		int j = n -1;
		int cur = 0;
		while (true) {
			j = n-1;
			while (j > 0 && values[j-1] > values[j])
				j--;
			if (j == 0)  //已经达到最后一个排列
				return;

			cur = j-1;
			while ( j < n && values[cur] < values[j])
				j++;

			swap(values, cur, j-1);
			reverse(values,cur+1);

			for (int v : values)
				System.out.print(v + " ");
			System.out.println();
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


}
