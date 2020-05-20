package com.thl.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
	private static boolean ans = false;
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		Test05 test = new Test05();
//		while (in.hasNext()) {
//			//木棍组合个数
//			int T = Integer.parseInt(in.nextLine());
//			for (int i = 0; i < T; i++) {
//				String line = in.nextLine();
//				String[] s = line.split(" ");
//				int[] arr = new int[Integer.parseInt(s[0])];
//				for (int j = 0; j < arr.length; j++)
//					arr[j] = Integer.parseInt(s[j+1]);
//
//				test.canWork(arr);
//				if (ans)
//					System.out.println("YES");
//				else System.out.println("NO");
//
//			}
//
//		}
		int[] arr = {1,1,2,2,2};
		test.canWork(arr);
		System.out.println(ans);
//		if (ans)
//			System.out.println("YES");
//		else System.out.println("NO");

	}

	public void canWork(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		if (sum % 4 != 0) {
			ans = false;
			return;
		}

		int[] visted = new int[arr.length];
		int len = sum/4;
		Arrays.sort(arr);
		if (len < arr[arr.length-1]) {
			ans = false;
			return;
		}

		dfs(arr,visted,0,len,0);
	}

	/**
	 *
	 *
	 *
	 * @param arr 存储火柴数组
	 * @param visited 已经遍历过的火柴
	 * @param finishLen 当前已经完成的边
	 * @param len 每条边的长度
	 * @param curLen 当前已经匹配到的长度
	 */
	public void dfs(int[] arr, int[] visited, int finishLen, int len, int curLen) {
		if (ans)
			return;

		if (curLen > len)
			return;

		if (curLen == len) {
			finishLen++;
			curLen = 0;
		}

		if (finishLen == 4) {
			ans = true;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				if (arr[i] == len)
					dfs(arr,visited,finishLen+1,len,curLen);
				else
					dfs(arr,visited,finishLen,len,curLen+arr[i]);

				visited[i] = 0;
			}

		}

	}
}
