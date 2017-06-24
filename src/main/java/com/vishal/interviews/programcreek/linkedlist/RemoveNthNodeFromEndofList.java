package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		// remove first node
		if (fast == null) {
			head = head.next;
			return head;
		}

		// fast pointer is n steps a head;
		ListNode slow = head;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;

	}

}
