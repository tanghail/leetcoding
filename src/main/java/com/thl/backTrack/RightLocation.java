package com.thl.backTrack;

/**
 *
 * 一个有2*n个元素的数组，n个奇数，n个偶数，设计算法是的数组奇数下标位置放置的都是奇数，偶数下标放置的都是偶数
 *
 */


public class RightLocation {
	public static void main(String[] args) {
		int[] arr = {2,4,3,1,5,7,6,8};
		setRightPostion(arr);
		int i = 0;
		for (int v : arr)
			System.out.println("index = " + i++ + ", value = " + v);
	}

	public static void setRightPostion(int[] arr){
		if (arr == null || arr.length == 0)
			return;

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int tail = (i&1);
			if ((arr[i]&1) == tail) {
				continue;
			}

			int j = i+1;
			while (j < len) {
				if ((arr[j]&1) == tail)
					break;
				j++;
			}

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
