package com.thl.bfs;


import java.util.Collections;
import java.util.Scanner;

/**
 *
 *
 */

public class Num_01 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int[] arr = new int[10];
//		int i = 0;
		// 读取参数
//		while (in.hasNext()) {
//			arr[i++] = in.nextInt();
//		}

		int[] arr = new int[]{1, 1, 1, 2, 2,1,1,1};

		System.out.println(getMin(arr));


	}

	public static int getMin(int[] arr){
		int min = Integer.MAX_VALUE;
		int size = arr.length;
		int sum = 0;
		for (int i = 0; i < size; i ++)
			sum += arr[i];

		if (sum == 0)
			return 0;

		//单张
		for (int i = 0; i < size; i++) {
			if (arr[i] > 0) {
				arr[i] = arr[i] -1;
				min = Math.min(min, 1+getMin(arr));
				arr[i] = arr[i] +1;
				break;
			}
		}

		//对子
		for (int i = 0; i < size; i++) {
			if (arr[i] >= 2) {
				arr[i] = arr[i] -2;
				min = Math.min(min, 1+getMin(arr));
				arr[i] = arr[i] +2;
				break;
			}
		}

		//连队
		for (int i = 0; i <= size-5; i++) {
			int j = i;
			for (; j < i+5; j++) {
				if (arr[j] < 2)
					break;
			}

			if (j - i == 5) {
				for (int k = i; k < j; k++)
					arr[k] = arr[k]  - 2;

				min = Math.min(min, 1+getMin(arr));
				for (int k = i; k < j; k++)
					arr[k] = arr[k] + 2;
			}
		}

		//顺子
		for (int i = 0; i <= size-5; i++) {
			int j = i;
			for (; j < i+5; j++) {
				if (arr[j] < 1)
					break;
			}

			if (j - i == 5) {
				for (int k = i; k < j; k++)
					arr[k] = arr[k] - 1;

				min = Math.min(min, 1+getMin(arr));
				for (int k = i; k < j; k++)
					arr[k] = arr[k] + 1;
			}
		}

		return min;
	}
}
