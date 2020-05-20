package com.thl.bfs;

import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 思路一：二叉树的解题方案都可以从递归的角度取思考
 *
 * 思路二：迭代法 用队列来保存一层的所有节点，但是如果是按照从左到右的顺序保存，这样需要考虑的问题过多
 * 			因此应当换一种保存方式，可以通过将两个对称的节点放在一起，这样节点值是偶数且节点值两两相同，则此层满足要求
 */

public class Num_101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

	/**
	 * 递归
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.val == root2.val)
			return isSymmetric(root1.left, root2.right)
					&& isSymmetric(root1.right, root2.left);

		return false;

	}

	/**
	 * 迭代，通过队列保存中间的节点值
	 * @param root
	 * @return
	 */
	public boolean isSymmetric2(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return true;

		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode node1 = queue.pop();
			TreeNode node2 = queue.pop();
			if (node1 == null && node2 == null)
				continue;

			if (node1 == null || node2 == null)
				return false;

			if (node1.val != node2.val)
				return false;

			//如果左右孩子只有一个为null，那返回false
			queue.add(node1.left);
			queue.add(node2.right);
			queue.add(node1.right);
			queue.add(node2.left);
		}

		return true;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
