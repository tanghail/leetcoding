package com.thl.tencent;

import java.util.Scanner;

public class test03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long count = Long.parseLong(input.nextLine());
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] s = line.split(" ");
			long x = Long.parseLong(s[0]);
			long k = Long.parseLong(s[1]);
			long left = (long) Math.pow(2,k-1);
			long right = (long) Math.pow(2,k) - 1;
			if (x < left || x <= right) {
				System.out.println(-1);
				continue;
			}
			while (x > right) {
				x = x/2;
			}

			System.out.println(x);
		}


	}
}
