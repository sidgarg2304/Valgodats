package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = findLen(headA);
		int lenB = findLen(headB);

		int d = Math.abs(lenA - lenB);
		ListNode c = lenA > lenB ? headA : headB;
		for (int i = 0; i < d; i++) {
			c = c.next;
		}

		ListNode n = lenA <= lenB ? headA : headB;

		while (n != null) {
			if (n.val == c.val) {
				return n;
			}
			n = n.next;
			c = c.next;
		}

		return null;

	}

	int findLen(ListNode node) {
		ListNode c = node;
		int r = 0;
		while (c != null) {
			r++;
			c = c.next;
		}
		return r;
	}
}
