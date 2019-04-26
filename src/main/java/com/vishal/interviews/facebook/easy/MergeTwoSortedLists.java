package com.vishal.interviews.facebook.easy;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode res = new ListNode(-1);

		ListNode r = res;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				r.next = l1;
				l1 = l1.next;
			} else {
				r.next = l2;
				l2 = l2.next;
			}
			r = r.next;
		}

		if (l1 != null) {
			r.next = l1;
		}

		if (l2 != null) {
			r.next = l2;

		}
		return res.next;
	}

}
