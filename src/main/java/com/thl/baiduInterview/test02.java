package com.thl.baiduInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i++)
				arr.add(scanner.nextInt());

			System.out.println(getStep(arr));
		}
	}

	public static int getStep(ArrayList<Integer> arr) {
		int max = Collections.max(arr);
		if (max < arr.size())
			return 0;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) != max)
				arr.set(i, arr.get(i)+1);
			else arr.set(i, max-arr.size());
		}

		return 1 + getStep(arr);

	}

}
