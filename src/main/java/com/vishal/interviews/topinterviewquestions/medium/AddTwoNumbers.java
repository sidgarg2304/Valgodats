package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		ListNode res = new ListNode(-1);

		ListNode r = res;

		int carry = 0;
		while (l1 != null || l2 != null) {
			int v1 = l1 != null ? l1.val : 0;
			int v2 = l2 != null ? l2.val : 0;
			int sum = v1 + v2 + carry;
			r.next = new ListNode(sum % 10);
			carry = sum / 10;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		if (carry != 0) {
			r.next = new ListNode(carry);
		}

		return res.next;
	}
}
