package com.thl.huawei;

import java.util.*;

/**
 * 回溯+贪心
 *
 *
 *
 */
public class Test05 {
	private static int minLength = Integer.MAX_VALUE;
	private static HashSet<Integer> visited = new HashSet<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Integer, TreeNode> map = new HashMap<>();
		while (input.hasNext()) {
			int K = Integer.parseInt(input.nextLine());
			int N = Integer.parseInt(input.nextLine());
			int R = Integer.parseInt(input.nextLine());
			for (int i = 0; i < R; i++) {
				String line = input.nextLine();
				String[] s = line.split(" ");

				//解析输入的道路长度和价格信息
				int city = Integer.parseInt(s[0]);
				int connectCity = Integer.parseInt(s[1]);
				int length = Integer.parseInt(s[2]);
				int cost = Integer.parseInt(s[3]);

				if (!map.containsKey(city))
					map.put(city, new TreeNode(city, new ArrayList<>(), new ArrayList<>()
							, new ArrayList<>()));

				if (!map.containsKey(connectCity))
					map.put(connectCity, new TreeNode(connectCity, new ArrayList<>()
							, new ArrayList<>(), new ArrayList<>()));

				map.get(city).connectCities.add(map.get(connectCity));
				map.get(city).length.add(length);
				map.get(city).costs.add(cost);

				map.get(connectCity).connectCities.add(map.get(city));
				map.get(connectCity).length.add(length);
				map.get(connectCity).costs.add(cost);
			}

			getMinCost(map.get(1),K,0,N,0, visited);
			System.out.println(minLength);
			minLength = Integer.MAX_VALUE;


		}




	}



	public static void getMinCost(TreeNode root, int hasCoin, int curCost, int target, int curLength
			, HashSet<Integer> visited) {
		if (root.connectCities.size() == 0) {
			if (root.city == target && hasCoin >= curCost) {
				if (minLength > curLength) {
					minLength = curLength;
				}
			}

			return;
		}

		List<TreeNode> connectCities = root.connectCities;
		for (int i = 0; i < connectCities.size(); i++) {
			if (!visited.contains(connectCities.get(i).city)) {
				visited.add(connectCities.get(i).city);
				getMinCost(connectCities.get(i), hasCoin, curCost+root.costs.get(i), target
						, curLength+root.length.get(i), visited);
				visited.remove(connectCities.get(i).city);
			}
		}

	}

}

class TreeNode {
	public TreeNode(int city, List<TreeNode> connectCities, List<Integer> length, List<Integer> costs) {
		this.city = city;
		this.connectCities = connectCities;
		this.length = length;
		this.costs = costs;
	}

	int city;
	List<TreeNode> connectCities;
	List<Integer> length;
	List<Integer> costs;
}
