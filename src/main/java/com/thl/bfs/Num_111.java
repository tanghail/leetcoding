package com.thl.bfs;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 思路一：广度优先，第一个找到的叶子节点对应的深度即为最小深度
 *
 * 思路二：递归方案
 *
 */

public class Num_111 {

	/**
	 * 深度优先算法实现
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			LinkedList<TreeNode> nodesForLevel = new LinkedList<TreeNode>();
			int size = queue.size();
			for (int i  = 0; i < size; i++) {
				TreeNode cur = queue.get(i);
				if (cur.left == null && cur.right == null)
					return level;

				if (cur.left != null) nodesForLevel.add(cur.left);
				if (cur.right != null) nodesForLevel.add(cur.right);
			}

			queue.clear();
			queue.addAll(nodesForLevel);
		}

		return -1;
	}

	public int minDepth2(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		int minDepth = Integer.MAX_VALUE;
		if (root.left != null)
			minDepth = Math.min(minDepth, minDepth2(root.left));

		if (root.right != null)
			minDepth = Math.min(minDepth, minDepth2(root.right));

		return minDepth + 1;
	}
}
