package com.thl.bfs;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 思路一：递归
 *
 * 思路二：深度优先搜索（DFS）
 *
 */

public class Num_559 {

	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		if (root.children.isEmpty())
			return 1;

		int maxDepth = Integer.MIN_VALUE;
		for (Node v : root.children) {
			if (v != null)
				maxDepth = Math.max(maxDepth, maxDepth(v));
		}

		return maxDepth+1;
	}

	private int maxDep = 0;
	public int maxDepth2(Node root) {
		if (root == null)
			return 0;

		dfs(root, 1);
		return maxDep;
	}

	public void dfs(Node root, int depth) {
		// depth 标记为当前的深度
		if (root == null)
			return;

		maxDep = Math.max(maxDep, depth);

		for (Node v : root.children) {
			dfs(v, depth+1);
		}
	}

}

class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
