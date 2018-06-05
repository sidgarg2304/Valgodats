package com.vishal.interviews.top100linkedquestions.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode res = new ListNode(-1);

		ListNode r = res;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int v1 = l1 == null ? 0 : l1.val;
			int v2 = l2 == null ? 0 : l2.val;

			int val = v1 + v2 + carry;

			r.next = new ListNode(val % 10);
			carry = val / 10;
			r = r.next;

			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}

		if (carry != 0) {
			r.next = new ListNode(carry);
		}

		return res.next;
	}

}
