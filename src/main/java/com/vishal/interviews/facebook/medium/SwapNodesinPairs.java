package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode swapPairs(ListNode head) {

		ListNode res = new ListNode(-1);
		
		if (head == null) {
			return res.next;
		}
		
		res.next = head;
		ListNode p = res; // -1
		while(p.next != null && p.next.next != null) {
			// 
			ListNode c = p.next; // -> 1
			ListNode n = c.next; // -> 2
			ListNode nn = n.next; // -> 3
			
			n.next = c; // 2 -> 1
			c.next = nn; // 1 -> 3
			p.next = n; // -1 -> 2
			
			p = c;
		}
		
		return res.next;

	}

}
