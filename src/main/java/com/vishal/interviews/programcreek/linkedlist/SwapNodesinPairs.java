package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class SwapNodesinPairs {

	public static void main(String[] args) {

	}

	// 1 2 3 4 5 6
	// 2 1 4 3 6 5
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode res = new ListNode(-1);

		ListNode p = res; // -1

		while (p.next != null && p.next.next != null) {
			ListNode t1 = p.next; // 1
			ListNode t2 = p.next.next; // 2
			ListNode t3 = p.next.next.next; // 3

			p.next = t2; // -1 -> 2
			t2.next = t1; // 2 -> 1
			t1.next = t3; // 1 -> 3

			p = t1;
		}

		return res.next;
	}

}
