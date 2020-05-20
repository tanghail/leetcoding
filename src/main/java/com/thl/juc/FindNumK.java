package com.thl.juc;

public class FindNumK {
	public static void main(String[] args) {

	}

	public Node findNumberK (Node head, int k) {
		if (head == null)
			return null;

		Node p1 = head, p2 = head;

		/**
		 * p1先走k步
		 */
		int count = 0;
		while (p1 != null && count < k-1) {
			p1 = p1.next;
			count++;
		}
		if (p1 == null)
			return null;

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}


}

class Node {
	int data;
	Node next;
}
