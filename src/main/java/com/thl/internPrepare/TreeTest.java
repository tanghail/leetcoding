package com.thl.internPrepare;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TreeTest {

	public List<List<Integer>> printTree(Node head) {
		List<List<Integer>> res = new ArrayList();
		ArrayDeque<Node> queue = new ArrayDeque<>();
		if (null == head)
			return res;

		int floor = 1;
		queue.add(head);
		res.add(new ArrayList<>(head.data));
		while (!queue.isEmpty()) {
			// 奇数层
			ArrayList<Integer> temp = new ArrayList<>();
			ArrayDeque<Node> tempNode = new ArrayDeque<>();
			if ((floor&1) == 1) {
				while (!queue.isEmpty()) {
					temp.add(queue.getFirst().data);
					tempNode.add(queue.getFirst().left);
					tempNode.add(queue.getFirst().right);
					queue.removeFirst();
				}

			} else {
				while (!queue.isEmpty()) {
					temp.add(queue.getFirst().data);
					tempNode.add(queue.getFirst().right);
					tempNode.add(queue.getFirst().left);
					queue.removeFirst();
				}

			}

			queue.addAll(tempNode);
			res.add(temp);
			floor++;

		}

		return res;
	}


}

class Node {
	int data;
	Node left;
	Node right;
}
