package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		ListNode r = ReverseLinkedList.reverseList(slow);
		ListNode c = head;

		while (r != null) {
			if (r.val != c.val) {
				return false;
			}

			r = r.next;
			c = c.next;

		}
		return true;
	}

}
