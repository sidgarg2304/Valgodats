package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int l1 = 0;
		ListNode a = headA;
		while (a != null) {
			l1++;
			a = a.next;
		}

		int l2 = 0;
		ListNode b = headB;
		while (b != null) {
			l2++;
			b = b.next;
		}

		ListNode h = l1 >= l2 ? headA : headB;
		ListNode s = l1 < l2 ? headA : headB;

		int diff = Math.abs(l1 - l2);

		while (diff > 0) {
			h = h.next;
			diff--;
		}

		ListNode r = null;
		while (h != null && s != null) {
			if (h.val == s.val) {
				r = h;
				break;
			}
			h = h.next;
			s = s.next;
		}

		return r;
	}

}
