package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {

	}

	public ListNode removeElements(ListNode head, int val) {

		ListNode res = new ListNode(0);

		ListNode c = head;
		ListNode p = res;

		while (c != null) {
			if (c.val == val) {
				p.next = c.next;
			} else {
				p.next = c;
			}
			p = p.next;
			c = c.next;
		}

		return res.next;
	}

}
