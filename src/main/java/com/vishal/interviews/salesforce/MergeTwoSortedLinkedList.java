package com.vishal.interviews.salesforce;

public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {

	}

	ListNode merge(ListNode headA, ListNode headB) {
		ListNode res = new ListNode(-1);

		ListNode r = res;
		ListNode h1 = headA;
		ListNode h2 = headB;
		while (h1 != null || h2 != null) {
			if (h1 == null) {
				r.next = h2;
				h2 = h2.next;
			} else if (h2 == null) {
				r.next = h1;
				h1 = h1.next;
			} else {
				if (h1.val < h2.val) {
					r.next = h1;
				} else {
					r.next = h2;
				}
			}
		}
		return res.next;
	}

}
