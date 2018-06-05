package com.vishal.interviews.top100linkedquestions.medium;

import com.vishal.interviews.util.ListNode;

public class SortList {

	public static void main(String[] args) {

	}

	// 1 2 3 4
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode f = head;
		ListNode s = head;
		while(f.next != null && f.next.next != null){
			f = f.next.next;
			s = s.next;
		}
		
		ListNode sec = s.next;
		s.next = null;
		
		ListNode sorted1 = sortList(head);
		ListNode sorted2 = sortList(sec);
		
		return merge(sorted1, sorted2);
	}

	ListNode merge(ListNode head1, ListNode head2) {

		ListNode res = new ListNode(-1);
		
		return res.next;
	}

}
