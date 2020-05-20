package com.thl.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下的打印二叉树
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 思路一：广度优先（）
 *
 * 思路二：深度优先
 * 深度优先的思路是，每一层的数组可通过当前的层号获取对应的数组
 *
 */

public class Num_32_2 {

	List<List<Integer>> ans = null;
	public List<List<Integer>> levelOrder(TreeNode root) {
		ans = new ArrayList<>();
		if (root == null)
			return ans;

		dfs(root, 1);
		return ans;
	}

	public void dfs(TreeNode root, int level){
		if (level > ans.size())
			ans.add(new ArrayList<>());

		List<Integer> list = ans.get(level-1);
		list.add(root.val);
		if (root.left != null) dfs(root.left, level+1);
		if (root.right != null) dfs(root.right, level+1);
	}
}
