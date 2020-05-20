package com.thl.backTrack;

/**
 *
 *
 */


public class TestOne {
	public static void main(String[] args) {
		Node head = new Node(0);
		Node cur = head;
		Node point = null;
		for (int i = 1; i < 10; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
			if (i == 5)
				point = node;
		}

		cur.next = point;

		TestOne testOne = new TestOne();
		Node node = testOne.hasCircle(head);
		System.out.println(node.date);


	}
	public Node hasCircle (Node head) {
		/**
		 * 快速结束
		 */
		if (head == null || head.next == null || head.next.next == null)
			return null;

		Node low = head;
		Node fast = head.next.next;
		while (low != fast) {
			if (fast.next == null || fast.next.next == null)
				return null;
			fast = fast.next.next;
			low = low.next;
		}

		fast = head;
		while (fast != low) {
			fast = fast.next;
			low = low.next;
		}

		return low;
	}
}

class Node {
	public int date;
	public Node next;

	public Node(int date) {
		this.date = date;
		this.next = null;
	}
}
