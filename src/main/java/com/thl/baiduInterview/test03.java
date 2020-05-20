package com.thl.baiduInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test03 {
	private static int size = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i ++)
				arr[i] = scanner.nextInt();

			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			while (scanner.hasNext()) {
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				ArrayList<Integer> integers = map.get(first);
				if (integers == null) {
					integers = new ArrayList<>();
					map.put(first, integers);
					integers.add(second);
				} else {
					map.get(first).add(second);
				}
			}

			dfs(map, 0, 0, arr);
			System.out.println(size);

		}
	}


	public static void dfs (HashMap<Integer, ArrayList<Integer>> map, int cur, int len, int[] value) {
		if (size < len) {
			size = len;
		}
		if (map.get(cur) == null)
			return ;

		if (map.get(cur+1).get(0) != null && value[cur] < value[map.get(cur+1).get(0)])
			dfs(map,map.get(cur+1).get(0), len+1, value );

		if (map.get(cur+1).get(1) != null &&value[cur] < value[map.get(cur+1).get(1)])
			dfs(map,map.get(cur+1).get(1), len+1, value );
	}

}
