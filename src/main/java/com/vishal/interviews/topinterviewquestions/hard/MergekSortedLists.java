package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;
import com.vishal.interviews.util.ListNode;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode(0);

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

		ListNode r = res;

		while (!minHeap.isEmpty()) {
			ListNode c = minHeap.poll();
			r.next = c;

			if (c.next != null) {
				minHeap.offer(c.next);
			}
			r = r.next;
		}

		return res.next;

	}

}
