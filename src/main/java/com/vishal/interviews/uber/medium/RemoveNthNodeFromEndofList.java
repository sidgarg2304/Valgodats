package com.vishal.interviews.uber.medium;

import com.vishal.interviews.util.ListNode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return head;
		}

		ListNode f = head;
		for (int i = 0; i < n; i++) {
			f = f.next;
		}

		if (f == null) {
			return head.next;
		}

		ListNode s = head;
		while (f.next != null) {
			f = f.next;
			s = s.next;
		}

		s.next = s.next.next;

		return head;

	}

}
