package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode c = head;
		ListNode s = reverse(slow);

		while (s != null) {
			if (s.val != c.val) {
				return false;
			}
			s = s.next;
			c = c.next;
		}
		return true;
	}

	ListNode reverse(ListNode head) {
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
