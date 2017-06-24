package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {

	}

	// 1 1 1 2 3 3 4 4 5
	// 2 5
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode res = new ListNode(-1);
		res.next = head;

		ListNode p = res;

		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}

		return res.next;

	}

}
