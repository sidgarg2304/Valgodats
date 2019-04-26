package com.vishal.interviews.uber.hard;

import java.util.*;

import com.vishal.interviews.util.ListNode;

public class MergekSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

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
