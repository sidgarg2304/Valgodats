package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.ListNode;

public class RotateList {

	public static void main(String[] args) {

	}

	public ListNode rotateRight(ListNode head, int k) {

		ListNode f = head;
		ListNode s = head;

		int l = 0;
		ListNode t = head;
		while(t != null){
			l++;
			t = t.next;
		}
		
		k = k % l;
		
		for (int i = 0; i < k && f != null; i++) {
			f = f.next;
		}

		while (f != null && f.next != null) {
			s = s.next;
			f = f.next;
		}

		ListNode secondPart = s.next;
		s.next = null;
		ListNode rs = reverse(secondPart);
		ListNode rf = reverse(head);
		head.next = rs;

		return reverse(rf);
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
