package com.vishal.interviews.google.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 */
public class MergekSortedLists {

	public static void main(String[] args) {

	}

}

/**
 * Difference between Priority-Queue and Heap, and C++ implementation
I have seen lots of solutions confuse priority queue with heap. I find a good link and list the talk below.

Concept:

1.Heap is a kind of data structure. It is a name for a particular way of storing data that makes certain operations very efficient. We can use a tree or array to describe it.

   18
  /	\
 10	 16
/ \   / \
9  5  8  12

18, 10, 16, 9, 5, 8, 12
2.Priority queue is an abstract datatype. It is a shorthand way of describing a particular interface and behavior, and says nothing about the underlying implementation.

A heap is a very good data structure to implement a priority queue. The operations which are made efficient by the heap data structure are the operations that the priority queue interface needs.
 */

/**
 * A java solution based on Priority Queue If someone understand how priority
 * queue works, then it would be trivial to walk through the codes.
 * 
 * My question: is that possible to solve this question under the same time
 * complexity without implementing the priority queue?
 */
class MergekSortedListsUsingPriorityQueue {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

	
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;

	}
}

class MergekSortedListsUsingRecursion{
	public static ListNode mergeKLists(ListNode[] lists){
	    return partion(lists,0,lists.length-1);
	}

	public static ListNode partion(ListNode[] lists,int s,int e){
	    if(s==e)  return lists[s];
	    if(s<e){
	        int q=(s+e)/2;
	        ListNode l1=partion(lists,s,q);
	        ListNode l2=partion(lists,q+1,e);
	        return merge(l1,l2);
	    }else
	        return null;
	}

	//This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1,ListNode l2){
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<l2.val){
	        l1.next=merge(l1.next,l2);
	        return l1;
	    }else{
	        l2.next=merge(l1,l2.next);
	        return l2;
	    }
	}
}