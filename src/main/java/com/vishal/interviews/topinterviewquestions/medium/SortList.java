package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.ListNode;

public class SortList {

	public static void main(String[] args) {

	}

	// 1->4->6 , 2->3->5
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
	
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}			
		
		ListNode right = sortList(slow.next);
		slow.next = null;
		ListNode left = sortList(head);			

		return merge(left, right);

	}

	ListNode merge(ListNode head1, ListNode head2) {

		if (head1 == null && head2 == null) {
			return null;
		}

		ListNode result = new ListNode(-1);

		ListNode l1 = head1;
		ListNode l2 = head2;

		ListNode r = result;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				r.next = l1;
				l1 = l1.next;
			} else {
				r.next = l2;
				l2 = l2.next;
			}
			r = r.next;
		}

		r.next = l1 == null ? l2 : l1;

		return result.next;
	}

}
