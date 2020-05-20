package com.thl.dynamicProgramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */

public class Num_121 {
	public static void main(String[] args) {
		Num_121 test = new Num_121();
		int[] nums = {7,1,5,3,6,4};
		System.out.println(test.maxProfit(nums));
	}


	/**
	 * 当前利润的最大值只和过去天数中的最小价格有关，因此通过一个变量来保存和状态发生改变相关的值即可
	 *
	 * 在分析使用dp解决问题时，重点把握三个方面：
	 * 	1、抓住影响状态改变的变量
	 * 	2、写出状态转移方程
	 * 	3、保存状态值的数据结构，一般同时需要对其进行初始化
	 *
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {

		int lowestProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			//状态i-1表示当前0～i-1的最低价格
			if (prices[i] > prices[i-1]) {
				lowestProfit = Math.max(lowestProfit, prices[i]-prices[i-1]);
			}
			prices[i] = Math.min(prices[i], prices[i-1]);
		}

		return lowestProfit;

	}
}
