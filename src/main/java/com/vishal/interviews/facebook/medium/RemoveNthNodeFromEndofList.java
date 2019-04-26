package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
// 1->2->3->4->5, and n = 2.
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
		// f -> 3

		ListNode s = head;
		while (f.next != null) {
			f = f.next;
			s = s.next;
		}

		// s -> 3
		s.next = s.next.next;
		

		return head;

	}

}
