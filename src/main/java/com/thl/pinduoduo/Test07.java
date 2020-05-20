package com.thl.pinduoduo;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = Integer.parseInt(in.nextLine());
////			long T = Long.parseLong(in.nextLine());
//			String line = in.nextLine();
//			String[] s = line.split(" ");
//			long[] arr = new long[T];
//			for (int i = 0; i < T; i++) {
//				arr[i] = Long.parseLong(s[i]);
//			}

//			System.out.println(dpFor(arr));

			System.out.println(Long.MAX_VALUE);

		}
	}



	public static long dpFor(long[] arr) {
		int len = arr.length;
		long[][] dp = new long[len][len];
		long max = -1;
		for (int i = 0; i < len; i++)
			dp[i][i] = arr[i];

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				dp[j][i] = gcd(dp[j][i-1], arr[i]);
				if (max < dp[j][i] * (i-j+1))
					max = dp[j][i] * (i-j+1);
			}
		}

		return max;
	}


	public static long gcd (long a, long b) {
		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		long x = a/b;
		long y = a%b;
		if (y == 0)
			return b;

		a = b;
		b = y;
		return gcd(a, b);
	}

}
