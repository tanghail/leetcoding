package com.thl.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long ans = 0;
			int n = Integer.parseInt(in.nextLine());
			String line = in.nextLine();
			String[] s = line.split(" ");
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = Long.parseLong(s[i]);

			Arrays.sort(arr);
			for (int i = 0; i < n-1; i++) {
				if (arr[i] >= arr[i+1]) {
					ans += arr[i] - arr[i+1] +1;
					arr[i+1] = arr[i]+1;
				}
			}

			System.out.println(ans);

		}

	}
}
