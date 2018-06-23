package com.vishal.interviews.salesforce;

import java.util.*;

public class MinStepsToReachEndofLinkedListWithRandomPointer {

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		one.random = four;
		four.random = two;
		
		System.out.println(minSteps(one));

	}

	// 1 -> 2 -> 3 -> 4 -> 5
	// 1 -> 4 -- random
	// 4 -> 2 -- random
	
	// result is 1 -> 4 using random and -> 5 using next
	static int minSteps(ListNode head) {		
		return minSteps(head, new HashSet<>());
	}
	
	//maintain visited to avoid loop as random can take you back to node you already visited
	static int minSteps(ListNode head, Set<Integer> visited) {

		if (head == null) {
			return 0;
		}

		if(visited.contains(head.val)){
			return Integer.MAX_VALUE;
		}
		visited.add(head.val);		
		int minWithNext = minSteps(head.next, visited);
		int minWithRandom = minSteps(head.random, visited);
		
		return 1 + Math.min(minWithRandom, minWithNext);
	}

}

class ListNode {

	ListNode(int val) {
		this.val = val;
	}

	ListNode next;
	ListNode random;
	int val;
}
