package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: given 1->2->3->4->5->NULL, m = 2 and n = 4, return
 * 1->4->3->2->5->NULL.
 *
 */
public class ReverseLinkedListII {

	public static void main(String[] args) {

		ListNode l = new ListNode(3);
		l.next = new ListNode(5);

		ListNode r = reverseBetween(l, 1, 2);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode res = new ListNode(-1);
		res.next = head;

		ListNode pre = res; // 1
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}

		ListNode p = pre.next; // 2
		ListNode c = p.next; // 3

		for (int i = 0; i < n - m; i++) {
			System.out.println("swapping");
			ListNode next = c.next;
			c.next = p;
			p = c;
			c = next;
		}

		pre.next.next = c;
		pre.next = p;

		return res.next;

	}
}
