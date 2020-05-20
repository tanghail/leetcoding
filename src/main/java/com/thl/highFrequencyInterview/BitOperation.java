package com.thl.highFrequencyInterview;


/**
 * 前缀和问题：可用于解决数组区间的问题, 统计数组前缀和的问题
 * 因此对于具体情境算法问题的求解，需要对问题进行抽象或者转换成算法的模型，转换成熟悉的算法问题求解，这是算法问题最复杂的部分
 *
 * 题型：查找一个数组中子数组之和等于K的子数组的个数
 *
 * 思路一：暴力破解法
 *
 * 思路二：前缀和法，通过前缀和数组保存前n个元素的和
 *
 * 思路三：通过hash表保存前n个元素的和
 *
 * 对于算法思想应该通过题型来记忆，根据题型判断来找到应该使用的算法，例如看到数据区间问题就联想到前缀和算法思想
 */

public class BitOperation {
	public static void main(String[] args) {
		// 字母与空格字符的'|'或操作可将字母字符转成小写字符
		System.out.println((char)('c' | ' '));

		// 字母与'_'的'&'或操作可将字母字符转成大写字符
		System.out.println((char)('c' & '_'));

		// 字母与空格字符的'^'异或操作可将字母字符转成大小写转换
		System.out.println((char)('c' ^ ' '));

		//判断两个数字是否异号,异或值小于0则两个值异号
		int x = 1;
		int y = 3;
		System.out.println((x^y) < 0);

		//交换两个数的值
		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println( x + " " + y);

		// n&(n-1)消除n的二进制的最后一个1

	}


}
