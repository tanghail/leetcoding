package com.thl.backTrack;

/**
 *
 *   鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *
 * 分析：f(k,n)表示确定k个鸡蛋，n层楼的f的值最小移动次数
 * 假设在楼层的任意位置（假设是K）丢下鸡蛋，
 * （1）若鸡蛋碎了，那F值在此楼之下的楼层，故f(k,n) = 1+f(k-1, K-1)
 *  (2) 若鸡蛋没碎，那F值在此楼之上的楼层， 故f(k,n) = 1+f(k, n-K)
 *  故f(k,n) = min（1 + max（f(k-1, K-1)， f(k, n-K) ）     ）   最优子结构
 *
 *
 * 为什么是max的原因，题目中的意思是在最坏的情况下的最小值，每次在取k值的情况下的最长操作次数为最坏的情况，在所有的k的情况下
 * 取最小值，此k即为最优的k
 *

 *  动态规划算法
 */


public class SuperEggDrop {
	public static void main(String[] args) {
		System.out.println(superEggDrop(2,6));
	}

	public static int superEggDrop(int eggs, int floors) {
		int[][] arr = new int[eggs + 1][floors + 1];

		for (int f = 0; f<=floors; f++)
			arr[1][f] = f;

		for (int floor = 1; floor <= floors; floor++) {
			for (int egg = 2; egg <= eggs; egg++) {
				int max;
				int min = Integer.MAX_VALUE;
				for (int k = 1; k <= floor; k++) {
					max = Math.max(arr[egg-1][k-1], arr[egg][floor - k])+1;
					if (min > max)
						min = max;
				}

				arr[egg][floor] = min;
			}
		}

		return arr[eggs][floors];
	}

}
