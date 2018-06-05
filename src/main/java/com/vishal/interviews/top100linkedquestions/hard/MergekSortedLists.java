package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

import com.vishal.interviews.util.ListNode;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {

		ListNode res = new ListNode(-1);

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>();
		for (ListNode l : lists) {
			if (l != null) {
				minHeap.offer(l);
			}
		}

		ListNode r = res;
		while (!minHeap.isEmpty()) {
			ListNode c = minHeap.poll();
			r.next = c;
			r = r.next;
			if (c.next != null) {
				minHeap.offer(c.next);
			}
		}

		return res.next;
	}

}
