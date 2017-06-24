package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {

	}

	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {		

			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

}
