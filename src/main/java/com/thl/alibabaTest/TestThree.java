package com.thl.alibabaTest;


/**
 * 实现如下程序：A、B线程运行结束后再运行C线程(给出多种实现)
 *
 */

public class TestThree {
	public static void main(String[] args) {
		int[] wells = {1,6,4};
		int[][] pips = {{1,2,1},{2,3,9}};
		System.out.println(getLowdestCost(3,wells, pips));
	}

	public static int getLowdestCost(int houseCount, int[] wells, int[][] list) {
		if (houseCount != list.length+1)
			return -1;

		int cost= Integer.MAX_VALUE;

		for (int i = 0; i < houseCount; i++) {

			int curCost = 0;
			curCost = wells[i];
			for (int j = 0; j < i; j++) {
				curCost += list[j][2];
			}

			for (int j = i; j < houseCount-1; j++) {
				curCost += list[j][2];
			}

			if (curCost < cost)
				cost = curCost;
		}

		return cost;



	}

}

