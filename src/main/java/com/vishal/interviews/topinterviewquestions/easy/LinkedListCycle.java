package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {

	}

	public boolean hasCycle(ListNode head) {
		
		if(head == null || head.next == null){
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

}
