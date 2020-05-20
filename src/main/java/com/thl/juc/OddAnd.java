package com.thl.juc;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *  所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。。
 *
 *  算法想象：
 *  将待排数组分成三个部分，奇数部分、偶数部分、以及待排部分，通过下标i标记偶数部分的第一个数，j标记待排部分的第一个数
 *
 */

public class OddAnd {
	public static void main(String[] args) {
		OddAnd test = new OddAnd();
		int[] arr = {2,5,7,3,8,4,11};
		test.reOrderArr(arr);
		for (int value : arr)
			System.out.print(value + " ");

	}

	public void reOrderArr(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		int i = 0;
		int len = arr.length;
		for (int j = 0; j < len; j++) {
			// 如果是偶数，
			if ((arr[j]&1) == 1) {
				int temp = arr[j];
				for (int k = j; k > i; k--) {
					arr[k] = arr[k-1];
				}
				arr[i] = temp;
				i++;
			}
		}
	}


}
