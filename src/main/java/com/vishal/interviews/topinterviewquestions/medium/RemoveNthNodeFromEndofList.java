package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.ListNode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

	}

	// 1->2->3->4->5, and n = 2
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		if (fast == null) {
			return head;
		}
		
		// fast starts at 3
		
		ListNode slow = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		// prev = 3
		// slow - 4

		slow.next = slow.next.next;

		return head;

	}

}
