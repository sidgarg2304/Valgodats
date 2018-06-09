package com.vishal.interviews.amazon.qae.easy;

public class LinkedListCycle {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		System.out.println(isCycleExist(head));

	}

	static boolean isCycleExist(ListNode head) {

		ListNode s = head;
		ListNode f = head;

		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;

			if (s == f) {
				return true;
			}

		}
		return false;
	}

}
