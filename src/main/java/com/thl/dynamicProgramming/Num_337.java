package com.thl.dynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 分析：对于二叉树的题目，都应该从递归的角度去思考
 *
 * 思路一：
 * 如果小偷考虑从当前值选择是否偷窃，那么有两种可能，第一：偷盗当前房间，金额为curValue加从孙子节点考虑是否偷窃的最大金额
 * 											  第二：不偷盗当前节点，从子节点考虑偷窃。 最后取两者的最大值
 *
 *
 */

public class Num_337 {

	public int rob(TreeNode root) {
		if (root == null)
			return 0;

		int money = root.val;
		if (root.left != null)
			money += (rob(root.left.left) + rob(root.left.right));

		if (root.right != null)
			money += (rob(root.right.left) + rob(root.right.right));

		return Math.max(money, rob(root.left) + rob(root.right));
	}

	public int rob2(TreeNode root) {
		if (root == null)
			return 0;

		HashMap<TreeNode, Integer> map = new HashMap<>();
		return robForRob2(root,map);
	}

	public int robForRob2(TreeNode root, HashMap<TreeNode, Integer> map) {
		if (root == null)
			return 0;

		if (map.containsKey(root))
			return map.get(root);

		int money = root.val;
		if (root.left != null)
			money += (robForRob2(root.left.left, map) + robForRob2(root.left.right, map));

		if (root.right != null)
			money += (robForRob2(root.right.left, map) + robForRob2(root.right.right,map));

		int ans = Math.max(money, robForRob2(root.left, map) + robForRob2(root.right,map));
		map.put(root, ans);
		return ans;
	}

	public int rob3(TreeNode root) {
		if (root == null)
			return 0;

		int[] ints = robForrob3(root);
		return Math.max(ints[0], ints[1]);
	}

	public int[] robForrob3(TreeNode root) {
		if (root == null) return new int[2];
		int[] res = new int[2];

		int[] left = robForrob3(root.left);
		int[] right = robForrob3(root.right);

		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];

		return res;
	}

}

class TreeNode {
	int val;
	TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
