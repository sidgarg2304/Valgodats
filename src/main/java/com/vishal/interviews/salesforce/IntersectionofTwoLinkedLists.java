package com.vishal.interviews.salesforce;

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
		for (int i = 0; i < d; i++) {
			h = h.next;
		}

		ListNode s = lenA < lenB ? headA : headB;

		while (h != null && s != null) {
			if (h.val == s.val) {
				return h;
			}
			s = s.next;
			h = h.next;
		}
		return null;

	}

}
