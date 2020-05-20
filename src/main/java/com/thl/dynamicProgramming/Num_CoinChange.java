package com.thl.dynamicProgramming;


import java.util.Arrays;

/**
 *
 */

public class Num_CoinChange {
	public static void main(String[] args) {
		Num_CoinChange test = new Num_CoinChange();
//		int[] nums = {1,2,5,7,10};
		int[] nums = {1,2,5};
		System.out.println(test.coinChange2(nums, 11));


	}

	/**
	 * 采用自底向上的动态规划的算法思想，用一个数组保存子问题的结果
	 * 如果dp[i] > amount表示当前金额i没有找到合适的硬币组合
	 *
	 * 状态转移方程为dp[i] = min(dp[i], dp[i-coins[j]]+1)   0 =<  j <coins.length
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i)
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);

			}
		}

		return dp[amount] > amount ? -1 : dp[amount];

	}

	/**
	 * 自顶向下的动态规划的算法思想，利用递归的方式
	 *
	 * 递归结构，数组保存子问题的结果
	 * dp[i]表示金额为i时的最少硬币个数
	 *
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange2(int[] coins, int amount) {
		if (amount < 0)
			return -1;

		int[] dp = new int[amount + 1];
		return dfs(coins, dp, amount);
	}

	private int dfs(int[] coins, int[] dp, int curChange) {
		if (curChange < 0)
			return -1;

		if (dp[curChange] != 0)
			return dp[curChange];

		if (curChange == 0)
			return 0;


		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int res = dfs(coins, dp, curChange - coins[i]);
			if (res >= 0) {
				min = Math.min(res+1, min);
			}
		}

		dp[curChange] = (min == Integer.MAX_VALUE)? -1 : min;
		return dp[curChange];
	}


}
