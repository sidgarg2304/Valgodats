package com.vishal.interviews.programcreek.sorting;

import com.vishal.interviews.util.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {

	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode res = new ListNode(-1);

		ListNode st = res;
		ListNode cur = head;		

		while (cur != null) {
			ListNode next = cur.next;

			while (st.next != null && st.next.val < cur.val) {
				st = st.next;
			}
			
			cur.next = st.next;
			st.next = cur;
			st = res;
			cur = next;
		}

		return res.next;
	}

}
