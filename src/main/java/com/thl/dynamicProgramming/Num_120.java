package com.thl.dynamicProgramming;


import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 */

public class Num_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		for (int i = len -2; i >= 0; i--) {
			List<Integer> list = triangle.get(i);
			List<Integer> nextList = triangle.get(i+1);
			for (int j = 0; j < list.size(); j++) {
				list.set(j, list.get(j) + Math.min(nextList.get(j), nextList.get(j+1)));
			}
		}


		return triangle.get(0).get(0);
	}
}
