package com.vishal.interviews.programcreek.heap;

import java.util.*;

import com.vishal.interviews.util.ListNode;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		for (ListNode l : lists) {
			if (l != null) {
				minHeap.offer(l);
			}
		}

		ListNode res = new ListNode(-1);
		ListNode r = res;

		while (!minHeap.isEmpty()) {
			ListNode cur = minHeap.poll();
			r.next = cur;

			if (cur.next != null) {
				minHeap.offer(cur.next);

			}
			r = r.next;
		}
		return res.next;

	}

}
