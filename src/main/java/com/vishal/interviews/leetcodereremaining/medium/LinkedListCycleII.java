package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {

		ListNode f = head;
		ListNode s = head;

		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}

		ListNode t = head;
		while (t != s) {
			t = t.next;
			s = s.next;
		}

		return t;
	}
}
