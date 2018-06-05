package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {

	}

	public ListNode oddEvenList(ListNode head) {

		ListNode odd = new ListNode(-1);
		ListNode even = new ListNode(-1);

		ListNode o = odd;
		ListNode e = even;

		ListNode p = head;
		boolean oddPos = true;
		while (p != null) {
			if (oddPos) {
				o.next = p;
				o = o.next;
			} else {
				e.next = p;
				e = e.next;
			}
			p = p.next;
			oddPos = !oddPos;
		}

		o.next = even.next;
		e.next = null;

		return odd.next;
	}
}
