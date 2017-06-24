package com.vishal.interviews.programcreek.sorting;

import com.vishal.interviews.util.ListNode;

public class Mergesort {

	public static void main(String[] args) {

	}

	public static ListNode mergeSortList(ListNode head) {

		// handle single element
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		prev.next = null;

		ListNode l1 = mergeSortList(head);
		ListNode l2 = mergeSortList(slow);

		return merge(l1, l2);

	}

	static ListNode merge(ListNode l1, ListNode l2) {

		ListNode res = new ListNode(-1);
		ListNode r = res;
		ListNode i = l1;
		ListNode j = l2;

		while (i != null && j != null) {

			if (i.val < j.val) {
				r.next = i;
				i = i.next;
			} else {
				r.next = j;
				j = j.next;
			}
			r = r.next;
		}

		if (i != null) {
			r.next = i;
		}

		if (j != null) {
			r.next = j;
		}

		return res.next;

	}

}
