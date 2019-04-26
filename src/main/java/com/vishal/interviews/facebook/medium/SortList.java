package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class SortList {

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

		ListNode l2 = slow.next;

		slow.next = null;

		ListNode sl1 = sortList(head);
		ListNode sl2 = sortList(l2);

		return merge(sl1, sl2);
	}

	ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null) {
			return list1 == null ? list2 : list1;
		}

		ListNode res = new ListNode(-1);
		ListNode r = res;
		ListNode l1 = list1;
		ListNode l2 = list2;

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

		if (l1 != null) {
			r.next = l1;
		}

		if (l2 != null) {
			r.next = l2;
		}
		return res.next;
	}

}
