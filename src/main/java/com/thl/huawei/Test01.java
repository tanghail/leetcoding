package com.thl.huawei;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] arr = line.split(" ");
			long a = Long.parseLong(arr[0]);
			long b = Long.parseLong(arr[1]);
			System.out.println(a+b);
		}


	}
}
