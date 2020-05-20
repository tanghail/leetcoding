package com.thl.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
	private static int minLucky = 0;
	private static char[] minLuckyChars = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int count = in.nextInt();
			int c = in.nextInt();
			String line = in.next();
			char[] chars = line.toCharArray();
			MaxLucky(chars, c);
			minLucky = 0;
			minLuckyChars = null;
		}

	}

	public static void MaxLucky(char[] data, int k) {
		int len = data.length;
		for (int i = 0; i < len; i++) {
			dfs(data, 0, k, 0, data[i]);
		}
		System.out.println(minLucky);
		System.out.println(new String(minLuckyChars));
	}

	public static void dfs (char[] data, int start, int remainK, int lucky, char select) {
		if (remainK == 0) {
			if (minLuckyChars == null) {
				minLucky = lucky;
				minLuckyChars = Arrays.copyOf(data, data.length);
			}else if (minLucky > lucky) {
				minLucky = lucky;
				minLuckyChars = Arrays.copyOf(data, data.length);;
			} else if (minLucky == lucky) {
				for (int i = 0 ; i < data.length; i++) {
					if (minLuckyChars[i] == data[i])
						continue;
					else if (minLuckyChars[i] < data[i]){
						break;
					} else {
						minLuckyChars = Arrays.copyOf(data, data.length);;
						break;
					}
				}
			}
			return;
		}

		if (start == data.length)
			return;

		for (int i = start; i < data.length; i++) {
			lucky += Math.abs(data[i] - select);
			char before = data[i];
			data[i] = select;
			dfs(data, i+1, remainK-1, lucky, select);
			data[i] = before;
			lucky -= Math.abs(data[i] - select);
		}
	}



}
