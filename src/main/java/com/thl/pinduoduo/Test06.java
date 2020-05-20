package com.thl.pinduoduo;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = Integer.parseInt(in.nextLine());
			for (int i = 0; i < T; i++) {
				String line = in.nextLine();
				String[] s = line.split(" ");
				long A = Long.parseLong(s[0]);
				long B = Long.parseLong(s[1]);
				long N = Long.parseLong(s[2]);
				if (canSplitByThree(A, B, N))
					System.out.println("YES");
				else System.out.println("NO");

			}

		}
	}

	public static boolean canSplitByThree(long A, long B, long  N) {
		long a = A;
		long b = B;
		if (N == 0)
			return A % 3 == 0;

		if (N == 1)
			return B % 3 == 0;

		for (long i = 2; i <= N; i++) {
			long temp = a + b;
			a = b;
			b = temp;
		}

		return b % 3 == 0;
	}

}
