package com.vishal.interviews.facebook.hard;

import com.vishal.interviews.util.ListNode;

import java.util.*;

/**
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 *
 */
public class MergekSortedLists {

	public static void main(String[] args) {

	}
	public ListNode mergeKLists(ListNode[] lists) {
      ListNode res = new ListNode(0);

		if (lists == null || lists.length == 0) {
			return res.next;
		}
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
		for(ListNode l : lists){
			if(l != null){
				minHeap.offer(l);
			}
		}

		ListNode r = res;
		while (!minHeap.isEmpty()) {
			ListNode p = minHeap.poll();
			r.next = p;
			if (p.next != null) {
				minHeap.offer(p.next);
			}
			r = r.next;
		}

		return res.next;
  }
}