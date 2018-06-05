package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = 0;
		ListNode a = headA;
		while (a != null) {
			lenA++;
			a = a.next;
		}

		int lenB = 0;
		ListNode b = headB;
		while (b != null) {
			lenB++;
			b = b.next;
		}

		int d = Math.abs(lenA - lenB);

		ListNode h = lenA > lenB ? headA : headB;

		while (d > 0) {
			h = h.next;
			d--;
		}

		ListNode s = lenA <= lenB ? headA : headB;

		while (s != null && h != null) {
			if (s.val == h.val) {
				return s;
			}
			s = s.next;
			h = h.next;
		}
		return null;

	}

}
