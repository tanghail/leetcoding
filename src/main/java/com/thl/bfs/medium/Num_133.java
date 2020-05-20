package com.thl.bfs.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 */
public class Num_133 {
	private static HashMap<Node, Node> visited = new HashMap<Node, Node>();
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		if (node.neighbors.isEmpty())
			return new Node(node.val);

		Node parent = new Node(node.val);
		bfs(parent, node);
		return parent;
	}

	public void bfs(Node parent, Node curNode) {
		if (visited.containsKey(curNode))
			return;

		visited.put(curNode, parent);
		List<Node> neighbors = curNode.neighbors;
		for (Node node : neighbors) {
			Node newNode = new Node(node.val);
			parent.neighbors.add(newNode);
			bfs(newNode, node);
		}
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
