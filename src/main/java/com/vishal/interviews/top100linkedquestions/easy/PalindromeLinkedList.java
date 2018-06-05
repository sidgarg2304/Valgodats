package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {

		ListNode f = head;
		ListNode s = head;
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}
		
		ListNode r = reverse(s.next);
		s.next = null;
		ListNode c = head;
		
		while(r != null){
			if(c.val != r.val){
				return false;
			}
			c = c.next;
			r = r.next;
		}
		
		return true;
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
