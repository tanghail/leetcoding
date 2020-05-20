package com.thl.bfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 思路一：BFS
 *
 * 思路二：DFS
 *
 */
public class Num_103 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			ArrayList<Integer> val = new ArrayList<>();
			LinkedList<TreeNode> nextLevel = new LinkedList<>();
			int size = queue.size();
			// 如果是奇数层，节点值从左向右读取,尾插法
			if ((level&1) == 1) {

				for (int i = 0; i < size; i++) {
					TreeNode curNode = queue.pollFirst();
					val.add(curNode.val);
					if (curNode.left != null) nextLevel.add(curNode.left);
					if (curNode.right != null) nextLevel.add(curNode.right);
				}
			} else {
				// 如果是偶数层，从尾部开始读取从右向左读，头插法
				for (int i = 0; i < size; i++) {
					TreeNode curNode = queue.pollLast();
					val.add(curNode.val);
					if (curNode.right != null) nextLevel.offerFirst(curNode.right);
					if (curNode.left != null) nextLevel.offerFirst(curNode.left);
				}
			}

			res.add(val);
			queue.addAll(nextLevel);
			level++;
		}

		return res;
	}


	private  List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		if (root == null)
			return ans;

		dfs(root, 1);
		return ans;
	}

	public void dfs(TreeNode root, int level) {
		if (level > ans.size())
			ans.add(new LinkedList<>());

		LinkedList<Integer> curLevel = (LinkedList<Integer>)ans.get(level);
		if ((level&1) == 1)
			curLevel.offerFirst(root.val);
		else
			curLevel.offerLast(root.val);

		if (root.left != null) dfs(root.left, level+1);
		if (root.right != null) dfs(root.right, level+1);
	}
}

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
