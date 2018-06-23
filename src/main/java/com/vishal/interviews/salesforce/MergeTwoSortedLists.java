package com.vishal.interviews.salesforce;

import com.vishal.interviews.util.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode res = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;

		while (p != null || q != null) {
			if (p == null) {
				res.next = q;
				q = q.next;
			} else if (q == null) {
				res.next = p;
				p = p.next;
			} else {
				if (p.val < q.val) {
					res.next = p;
					p = p.next;
				} else {
					res.next = q;
					q = q.next;
				}
			}
			res = res.next;
		}

		return res.next;
	}

}
