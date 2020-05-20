package com.thl.huawei;

import java.util.Scanner;
import java.util.logging.Level;

public class Test06 {

	public static void main(String[] args) {
	}

	public int getIndex(int[] gas, int[] cost) {
		int sum = 0;
		int start = 0;
		int cur = 0;
		int start2 = 0;

		while (start < gas.length && cur < cost.length && gas[start] < cost[cur]) {
			start++;
			cur++;
		}

		if (start2 == start)
			return -1;

		cur++;
		while (cur != start) {
			sum += gas[cur];
			if (sum + gas[cur] > cost[cur])
				cur++;
			else {
				break;
			}
		}

		if (cur != start)
			return -1;

		return start;
	}

	/**
	 * sumGas参数表示汽车跑完一圈油箱还剩下多少油，只有sumGas为非负数时汽车才能跑完一圈。
	 * 假如此时sumGas 》 0， 并且存在某个加油站有gas[i] < cost[i]那么，那么在下一站之后剩下的油一定会大于 cost[i]-gas[i]
	 * 因此题目所求的节点一定是在当前节点之后的所有节点都不存在gas[i] < cost[i]这种节点
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int getIndex2(int[] gas, int[] cost) {
		int sumGas = 0;
		int curGas = 0;
		int startStation = 0;
		for (int i = 0; i < gas.length; i++) {
			sumGas += gas[i] - cost[i];
			curGas += gas[i] - cost[i];
			if (curGas < 0) {
				curGas = 0;
				startStation = i+1;
			}
		}

		return sumGas > 0 ? startStation : -1;
	}
}
