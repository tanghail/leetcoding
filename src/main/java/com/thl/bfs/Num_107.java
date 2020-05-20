package com.thl.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 思路一：通过队列保存每层的节点值，最后将数组倒置
 *
 * 思路二：递归的方式（参考二叉树的后序遍历算法）
 * 先递归遍历每一层的节点，最后将这层的节点值保存,递归的思路需要好好体会一下
 *  最重要的是找到递归式
 *
 * 思路三：深度优先（DFS）
 * 可以参考二叉树的先序遍历算法
 */

public class Num_107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		List<TreeNode> curNode = new LinkedList<>();

		if (root == null) {
			res.add(new ArrayList<>());
			return res;
		}

		curNode.add(root);
		while (!curNode.isEmpty()) {
			int size = curNode.size();
			LinkedList<TreeNode> nextLevel = new LinkedList<>();
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				temp.add(curNode.get(i).val);
				if (curNode.get(i).left != null) nextLevel.add(curNode.get(i).left);
				if (curNode.get(i).right != null) nextLevel.add(curNode.get(i).right);
			}

			curNode.clear();
			curNode.addAll(nextLevel);
			res.add(temp);
		}

		Collections.reverse(res);
		return res;
	}

	private  List<List<Integer>> ans = new ArrayList();
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		if (root == null) {
			ans.add(new ArrayList<>());
			return ans;
		}

		ArrayList<TreeNode> treeNodes = new ArrayList<>();
		treeNodes.add(root);
		visitedByLevel(treeNodes);

		return ans;

	}

	public void visitedByLevel(List<TreeNode> level) {
		if (level.isEmpty())
			return;

		ArrayList<Integer> vals = new ArrayList<>();  //保存当前层节点值
		ArrayList<TreeNode> nextLevel = new ArrayList<>();
		for (int i = 0; i < level.size(); i++) {
			vals.add(level.get(i).val);
			if (level.get(i).left != null) nextLevel.add(level.get(i).left);
			if (level.get(i).right != null) nextLevel.add(level.get(i).right);
		}

		visitedByLevel(nextLevel);
		ans.add(vals);

	}

}
