package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode reverseBetween(ListNode head, int m, int n) {

		if(m == n){
			return head;
		}
		ListNode res = new ListNode(-1);
		res.next = head;
		
		ListNode h = res;
		for (int i = 0; i < m - 1; i++) {
			h = h.next;
		}
		ListNode rSt = h.next;

		ListNode p = null;
		ListNode c = h.next;
		ListNode next = null;
		for (int i = m; i <= n; i++) {
			next = c.next;
			c.next = p;
			p = c;
			c = next;
		}
		h.next = p;
		rSt.next = next;
		
		return res.next;
	}

}
