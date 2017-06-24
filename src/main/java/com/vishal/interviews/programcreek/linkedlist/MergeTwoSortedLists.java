package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(-1);
		ListNode res = result;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				res.next = l2;
				l2 = l2.next;
			} else if (l2 == null) {
				res.next = l1;
				l1 = l1.next;
			} else {
				if (l1.val < l2.val) {
					res.next = l1;
					l1 = l1.next;
				} else {
					res.next = l2;
					l2 = l2.next;
				}
			}
			res = res.next;
		}

		return result.next;
	}

}
