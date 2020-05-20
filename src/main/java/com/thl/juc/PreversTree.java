package com.thl.juc;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PreversTree {
	public static void main(String[] args) {


	}

	public void pretravers (TreeNode head) {
		if (head == null)
			return;
		System.out.println(head.data);
		pretravers(head.left);
		pretravers(head.right);
	}

	public void pretraversWithStack(TreeNode head) {
		if (head == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(head);
		TreeNode cur = null;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			while (!stack.isEmpty() && cur.left!= null) {
				cur = cur.left;
				System.out.println(cur.data);
				stack.push(cur);
			}

			if (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				if (node.right != null) {
					System.out.println(node.data);
					stack.push(node.right);
				}
			}
		}

	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int data;
}
