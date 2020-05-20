package com.thl.highFrequencyInterview;

/**
 * kek额喜欢吃香蕉，这里有N堆香蕉，第i堆中有pipes[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * keke可以决定吃香蕉的速度K（根/小时），每个小时他可以选择一堆香蕉从中吃掉K根，如果不足K根，全部吃完之后将在此小时内不再吃其他堆的香蕉
 * keke喜欢满满吃，但仍想在警卫回来之前吃掉所有的香蕉
 *
 * 返回他可以在H小时吃掉所有香蕉的最小速度 K（K为整数）
 *
 * 分析：
 * 思路一：暴力破解法：从1到堆中最大的香蕉数量，一次判断速度是否满足
 *
 * 思路二：在一的基础上，通过二分法剪枝，如果keke每小时吃K根香蕉能在H小时内吃完所有的香蕉，那么每小时大于K的速度肯定可以吃完，所以结果在不大于K
 *        的速度中
 *
 */

public class KoKoBananas {
	public static void main(String[] args) {
		KoKoBananas test = new KoKoBananas();
		int[] pipes = {30,11,23,4,20};
		System.out.println(test.getMinSpeed(pipes, 5));
	}

	public int getMinSpeed(int[] pipes, int H) {
		int left = 1;
		int right = getMax(pipes)+1;
		while (left < right) {
			int mid = (right + left) / 2;
			if (canFinish(mid, H, pipes)){
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;

	}

	public  boolean canFinish(int speed, int H, int[] pipes) {
		int len = pipes.length;
		int hours = 0;
		for (int i = 0; i < len; i++) {
			hours += ((pipes[i]/speed) + (pipes[i]%speed > 0 ? 1 : 0));
		}

		return hours <= H;
	}

	public int getMax(int[] nums) {
		int len = nums.length;
		int max = nums[0];
		for (int value : nums)
			if (value > max) {
				max = value;
			}
		return max;
	}
}
