package com.thl.bfs;


import java.util.LinkedList;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false
 *
 * 思路一：广度优先 在每层查找是否有指定的节点，
 *
 * 思路二：深度优先，通过变量保存两个节点值对应的层数
 */

public class Num_993 {

	/**
	 * 广度优先的实现，使用队列来对每一层的节点进行迭代
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		TreeNode xParent = null;
		TreeNode yParent = null;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			LinkedList<TreeNode> nextLevel = new LinkedList<>();
			int isMatched = 0;
			int size = queue.size();

			while (!queue.isEmpty()) {
				TreeNode curNode = queue.pollFirst();
				if (curNode.left != null) {
					if (curNode.left.val == x) {
						isMatched++;
						xParent = curNode;
					}

					if (curNode.left.val == y) {
						isMatched++;
						yParent = curNode;
					}
					nextLevel.add(curNode.left);
				}

				if (curNode.right != null) {
					if (curNode.right.val == x) {
						isMatched++;
						xParent = curNode;
					}

					if (curNode.right.val == y) {
						isMatched++;
						yParent = curNode;
					}
					nextLevel.add(curNode.right);
				}

			}

			if (isMatched == 2 && xParent != yParent)
				return true;

			queue.addAll(nextLevel);
		}

		return false;
	}

	/**
	 * 深度优先搜索
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	private int xLevel;
	private int yLevel;
	private TreeNode xParent;
	private TreeNode yParent;
	private int hasMatch = 0;
	public boolean isCousins2(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		dfs(root, x,y, 1, root);
		return xLevel == yLevel && xParent != yParent;

	}

	public void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
		if (root == null || hasMatch == 2)
			return;

		if (root.val == x) {
			xLevel = level;
			xParent = parent;
			hasMatch++;
		}

		if (root.val == y) {
			yLevel = level;
			yParent = parent;
			hasMatch++;
		}

		if (root.left != null) dfs(root.left, x, y, level+1, root);
		if (root.right != null) dfs(root.right, x, y, level+1, root);
	}
}
