package com.thl.hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 方法一：构造一个和数组大小相同的hashset（可随机读取）保存数据，准备将数组中的数据一次加入，如果当前数据不在hashset中，加入；存在返回true；
 *
 * 方法二：排序算法
 *
 * 方法三：线性查找
 * 		 将当前的数依次和左边的已遍历数组元素比较，判断是否存在相同的元素，时间复杂度为 O(n*n)
 *
 */


public class Num_217 {
	public static void main(String[] args) {

	}

	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;
		HashSet<Integer> set = new HashSet<Integer>(len);
		for (int value : nums) {
			if (set.contains(value))
				return true;
			set.add(value);
		}

		return false;
	}
}
