package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbersII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		ListNode r1 = reverse(l1);
		ListNode r2 = reverse(l2);

		ListNode res = new ListNode(-1);

		ListNode r = res;
		int carry = 0;
		while (r1 != null || r2 != null) {
			int val1 = r1 != null ? r1.val : 0;
			int val2 = r2 != null ? r2.val : 0;

			int sum = val1 + val2 + carry;
			r.next = new ListNode(sum % 10);
			carry = sum / 10;
			r = r.next;
			if (r1 != null) {
				r1 = r1.next;
			}
			if (r2 != null) {
				r2 = r2.next;
			}
		}
		if (carry != 0) {
			r.next = new ListNode(carry);
		}
		return reverse(res.next);
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
