package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}
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
