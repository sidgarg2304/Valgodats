package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class ReverseNodesinkGroup {

	public static void main(String[] args) {

	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}

		ListNode cur = head;
		int cnt = 0;
		while (cnt < k && cur != null) {
			cur = cur.next;
			cnt++;
		}

		if (cnt == k) {
			ListNode p = reverseKGroup(cur, k);
			ListNode c = head;

			while (cnt-- > 0) {
				ListNode n = c.next;
				c.next = p;
				p = c;
				c = n;
			}
			head = p;
		}
		return head;
	}
}
