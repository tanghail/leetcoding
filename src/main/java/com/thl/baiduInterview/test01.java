package com.thl.baiduInterview;

import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j++) {
					int temp = lcm(i, j) - gcd(i, j);
//					System.out.println(lcm(i, j));
//					System.out.println(gcd(i, j));
//					System.out.println(temp);
					temp = Math.abs(temp);
					if (temp > max)
						max = temp;
				}
			}
			System.out.println(max);
		}

	}

	public static int lcm (int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int x = a/b;
		int y = a%b;
		if (y == 0)
			return b;

		a = b;
		b = y;
		return lcm(a, b);
	}

	//最小公倍数
	public static int gcd(int a, int b) {
		if (lcm(a,b) == 1)
			return a*b;

		return lcm(a,b) * gcd(a/lcm(a,b), b/lcm(a,b));
	}
}
