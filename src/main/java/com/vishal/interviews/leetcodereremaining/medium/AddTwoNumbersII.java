package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbersII {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode r1 = reverse(l1);
		ListNode r2 = reverse(l2);

		ListNode res = new ListNode(-1);

		ListNode r = res;

		int carry = 0;
		while (r1 != null || r2 != null) {
			int val1 = r1 == null ? 0 : r1.val;
			int val2 = r2 == null ? 0 : r2.val;

			int sum = val1 + val2 + carry;
			r.next = new ListNode(sum % 10);
			carry = sum / 10;

			r1 = (r1 == null) ? null : r1.next;
			r2 = (r2 == null) ? null : r2.next;
			r = r.next;
		}

		if(carry != 0){
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
