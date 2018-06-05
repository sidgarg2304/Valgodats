package com.vishal.interviews.top100linkedquestions.medium;

import com.vishal.interviews.util.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {

	}

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode f = head;
		ListNode s = head;
		boolean cycle = false;
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
			if (f == s) {
				cycle = true;
				break;
			}
		}

		if (!cycle) {
			return null;
		}

		ListNode t = head;
		while (s != t) {
			t = t.next;
			s = s.next;

		}

		return t;

	}

}
