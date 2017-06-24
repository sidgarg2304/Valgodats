package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {

	}

	// 1 -> 2 -> 3 -> 4 -> 5 -> 6
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;

		ListNode result = head;

		ListNode secondResNode = head.next;
		
		ListNode p1 = head; // 1
		ListNode p2 = head.next; // 2

		while (p1 != null && p2 != null) {			
			ListNode temp2 = p2.next; // 3

			if (temp2 == null) {
				break;
			}

			p1.next = p2.next; // 1 -> 3
			p1 = p1.next;
			
			p2.next = p1.next; // 2 -> 4			
			p2 = p2.next;
		}

		p1.next = secondResNode;
		
		return result;

	}

}
