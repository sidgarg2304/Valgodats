package com.vishal.interviews.facebook.easy;


public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		ListNode fast = head;
		ListNode slow = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
