package com.thl.bfs.medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *   思路一：层次遍历的最右侧的节点
 *
 *   思路二：深度优先算法:第三种做法
 *
 *   变题：
 *   （1）左视图
 *   （2）
 *
 *
 */
public class Num_199 {
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		res.add(root.val);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode first = queue.pollFirst();
				if (i == size -1)
					res.add(first.val);
				if (first.left != null) queue.addLast(first.left);
				if (first.right != null) queue.addLast(first.right);
			}
		}

		return res;
	}

	/**
	 * 递归法：
	 * 用数组表示当前的最大深度（最大深度可以理解为当前找到的右视图节点的最大深度）
	 *
	 * 因此本题如果用深度优先法，可以理解为：找到每一层的最右侧节点，同时保存已经递归到的最大深度（意味着此时小于最大深度的层已经找到最优的节点）
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView2(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		assembly(root, result, 1);

		return result;
	}

	private void assembly(TreeNode root, List<Integer> result, int n) {

		if (result.size() == n - 1) {
			result.add(root.val);
		}

		if (root.right != null) {
			assembly(root.right, result, n + 1);
		}
		if (root.left != null) {
			assembly(root.left, result, n + 1);
		}
	}

	/**
	 * 通过map保存每一层的最右侧的节点,
	 * @param root
	 * @return
	 */
	private int map_level = 0;
	public List<Integer> rightSideView3(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		HashMap<Integer, Integer> map = new HashMap<>();
		dfs(root, 1,map);
		Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
		for (Map.Entry<Integer, Integer> entry : entries)
			res.add(entry.getValue());

		return res;
	}

	private void dfs(TreeNode root, int curlevel, HashMap<Integer, Integer> map) {
		if (root == null)
			return;

		if (curlevel > map_level) {
			map_level = curlevel;
			map.put(map_level, root.val);
		}

		dfs(root.right,curlevel+1,  map);
		dfs(root.left,curlevel+1,  map);
	}

}
