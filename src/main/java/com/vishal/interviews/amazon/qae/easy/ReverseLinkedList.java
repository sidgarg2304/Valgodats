package com.vishal.interviews.amazon.qae.easy;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}

	// 1 -> 2 -> 3
	public ListNode reverseList(ListNode head) {

		ListNode p = null;
		ListNode c = head;

		while (c != null) {
			ListNode n = c.next;
			c.next = p;
			p = c;
			c = n;
		}

		return p;
	}

}

class ListNode {

	public ListNode next;
	public int val;

	public ListNode(int val) {
		this.val = val;
	}

}
