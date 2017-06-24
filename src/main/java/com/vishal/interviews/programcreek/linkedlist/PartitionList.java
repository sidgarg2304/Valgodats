package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.datastructures.linkedlist.LinkedListPrograms;
import com.vishal.interviews.util.ListNode;

public class PartitionList {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		ListNode r = partition(l1, 2);

		// printLinkedList(r);

	}

	static void printLinkedList(ListNode root) {

		ListNode p = root;
		while (p != null) {
			System.out.print(p.val + " -> ");
			p = p.next;
		}
		System.out.println("");
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode smaller = new ListNode(-1);
		ListNode higher = new ListNode(-1);

		ListNode c = head;
		ListNode s = smaller;
		ListNode h = higher;

		while (c != null) {

			if (c.val < x) {
				s.next = c;
				s = s.next;
			} else {
				h.next = c;
				h = h.next;
			}

			c = c.next;
		}

		h.next = null;

		s.next = higher.next;

		return smaller.next;
	}

}
