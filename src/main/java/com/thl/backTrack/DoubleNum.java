package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 从一个数组中选出所有的K个连续不重复的子序列
 *
 * 此题使用回溯法：
 *
 */


public class DoubleNum {
	public static void main(String[] args) {
		ArrayList<Integer> temp = new ArrayList();
		List<List<Integer>> res = new ArrayList();
		int[] arr = {1,2,3,4,5,5,6,7,8};
		doubleNumOfK(arr, res, temp, 3, 0);
		for (List<Integer> e : res) {
			for (int data : e) {
				System.out.print(data + "  ");
			}
			System.out.println();
		}

	}

	public static void doubleNumOfK(int[] arr, List<List<Integer>> res, List<Integer> temp, int k, int start){
		if (temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		if (arr.length - start < k)
			return;

		for (int i = start; i < arr.length; i++) {
			if (temp.size() == 0) {
				temp.add(arr[i]);
				doubleNumOfK(arr, res, temp, k, i + 1);
				temp.remove(temp.size() - 1);
			} else {
				if (temp.get(temp.size() - 1) == arr[i]) {  //有重复
				} else {
					temp.add(arr[i]);
					doubleNumOfK(arr, res, temp, k, i+1);
					temp.remove(temp.size() - 1);
				}
			}
		}

	}
}