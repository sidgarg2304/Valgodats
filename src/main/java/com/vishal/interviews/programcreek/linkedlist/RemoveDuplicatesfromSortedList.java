package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

	}

	// 1 1 2 2 2 3
	// 1 2 3
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode result = head;
		ListNode p = head;

		ListNode n = head.next;

		while (p != null) {
			while (n != null && n.val == p.val) {
				n = n.next;
			}

			p.next = n;
			p = n;
			n = n.next;
		}

		return result;

	}

}
