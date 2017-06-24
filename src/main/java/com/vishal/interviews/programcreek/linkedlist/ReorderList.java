package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class ReorderList {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;

		reorderList(l1);

	}

	static void printList(ListNode l) {
		while (l != null) {
			System.out.print(l.val + "->");
			l = l.next;
		}
		System.out.println("");
	}

	public static void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode c = head;

		ListNode r = reverse(slow.next);
		slow.next = null;

		while (r != null) {
			ListNode temp1 = c.next;
			ListNode temp2 = r.next;

			c.next = r;
			r.next = temp1;

			c = temp1;
			r = temp2;
		}

		printList(head);
	}

	static ListNode reverse(ListNode head) {

		if (head == null) {
			return head;
		}
		ListNode p = null;
		ListNode c = head;

		while (c != null) {
			ListNode n = c.next;
			c.next = p;
			p = c;
			c = n;
		}

		return p;
	}

}
