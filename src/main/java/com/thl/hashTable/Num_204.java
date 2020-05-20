package com.thl.hashTable;

/**
 * 统计所有小于非负整数 n 的质数的数量
 *
 * 思路一：遍历所有的数字，判断是否为质数
 *
 * 思路二：埃拉托色尼筛选法（筛选一定范围内数质数的集合，
 * 参考链接：https://baike.baidu.com/item/%E5%9F%83%E6%8B%89%E6%89%98%E8%89%B2%E5%B0%BC%E7%AD%9B%E9%80%89%E6%B3%95/4524938?fr=aladdin）
 */


public class Num_204 {
	public static void main(String[] args) {
		boolean[] isPrime = new boolean[3];
		System.out.println(isPrime[0]);
	}


	public int countPrimes(int n) {
		if (n <= 1)
			return 0;

		boolean[] isPrime = new boolean[n];
		for (int i = 0; i < n; i++)
			isPrime[i] = true;

		for (int i = 2; i*i < n; i++){
			if (isPrime[i]) {
				for (int j = i*i; j < n; j += i)
					isPrime[j] = false;
			}
		}

		//判断isPrime中有多少个true；
		int count  = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime[i])
				count++;
		}

		return count;
	}
}
