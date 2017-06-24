package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.datastructures.linkedlist.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode<Integer> l1 = new ListNode<Integer>(2);
		ListNode<Integer> l2 = new ListNode<Integer>(6);
		ListNode<Integer> l3 = new ListNode<Integer>(4);
		ListNode<Integer> l4 = new ListNode<Integer>(7);
		ListNode<Integer> l5 = new ListNode<Integer>(0);
		ListNode<Integer> l6 = new ListNode<Integer>(2);
		ListNode<Integer> l7 = new ListNode<Integer>(7);
		ListNode<Integer> l8 = new ListNode<Integer>(2);
		ListNode<Integer> l9 = new ListNode<Integer>(1);
		ListNode<Integer> l10 = new ListNode<Integer>(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;

		ListNode<Integer> r1 = new ListNode<Integer>(2);
		ListNode<Integer> r2 = new ListNode<Integer>(2);
		ListNode<Integer> r3 = new ListNode<Integer>(8);
		ListNode<Integer> r4 = new ListNode<Integer>(2);
		ListNode<Integer> r5 = new ListNode<Integer>(5);
		ListNode<Integer> r6 = new ListNode<Integer>(5);
		ListNode<Integer> r7 = new ListNode<Integer>(5);
		ListNode<Integer> r8 = new ListNode<Integer>(8);
		ListNode<Integer> r9 = new ListNode<Integer>(7);
		ListNode<Integer> r10 = new ListNode<Integer>(1);

		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		r5.next = r6;
		r6.next = r7;
		r7.next = r8;
		r8.next = r9;
		r9.next = r10;

		ListNode<Integer> r = addTwoNumbers(l1, r1);

		while (r != null) {
			System.out.println(r.value);
			r = r.next;
		}

	}

	public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode<Integer> res = new ListNode<Integer>(-1);

		ListNode<Integer> r = res;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = (l1 != null) ? l1.value : 0;
			int val2 = (l2 != null) ? l2.value : 0;

			int sum = val1 + val2 + carry;

			r.next = new ListNode<Integer>(sum % 10);
			r = r.next;
			carry = sum / 10;

			l1 = (l1 != null) ? l1.next : l1;
			l2 = (l2 != null) ? l2.next : l2;
		}

		if (carry != 0) {
			r.next = new ListNode<Integer>(carry);
		}

		return res.next;

	}

}
