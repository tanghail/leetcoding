package com.thl.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 思路1：计算0:00 ~ 12:00 每个时间点有多少个1（此题用暴力解法会更快）
 *
 * 思路2：通过数组保存时针下每个1所代表的所有可能的情况
 *
 *
 *
 */


public class Num_401 {
	public static void main(String[] args) {
		System.out.println('A' - 'a');
	}

	public List<String> readBinaryWatch(int num) {
		if (num < 0 || num > 8)
			return null;

		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				if (count(i) + count(j) == num) {
					res.add(j < 10 ?i + ":" + "0" + j : i + ":"  + j);
				}
			}
		}
		return res;
	}

//	public List<String> readBinaryWatch(int num) {
//		ArrayList<String> res = new ArrayList<String>();
//		if (num < 0 || num > 8)
//			return res;
//
//		String[][] hours = {{"0"}, {"1","2","4","8"},{"3","5","9","6","10","12"},{"7","11"}};
//		String[][] minus = {{"00"},{"01","02","04","08","16","32"},{},{}};
//
//	}


	/**
	 * 计算一个十进制数转成二进制有多少个1
	 */
	public int count(int num){
		int count = 0;
		while (num != 0) {
			if ((num&1) == 1)
				count++;
			num = num >>> 1;
		}

		return count;
	}

}
