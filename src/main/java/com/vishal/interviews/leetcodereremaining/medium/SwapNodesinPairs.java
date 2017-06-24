package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.ListNode;

public class SwapNodesinPairs {

	public static void main(String[] args) {

	}

	public ListNode swapPairs(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode res = new ListNode(-1);
		res.next = head;

		ListNode p = res; // -1
		while (p.next != null && p.next.next != null) {
			ListNode t1 = p.next; // 1
			ListNode t2 = p.next.next; // 2
			ListNode t3 = p.next.next.next; // 3

			t2.next = t1; // 2 -> 1
			t1.next = t3; // 1-> 3
			p.next = t2;

			p = t1;

		}

		return res.next;
	}

}
