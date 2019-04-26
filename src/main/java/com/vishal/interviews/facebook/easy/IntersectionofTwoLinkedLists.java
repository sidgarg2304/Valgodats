package com.vishal.interviews.facebook.easy;

import java.util.*;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		Stack<ListNode> stackA = new Stack<>();
		Stack<ListNode> stackB = new Stack<>();

		ListNode ha = headA;
		while (ha != null) {
			stackA.push(ha);
			ha = ha.next;
		}

		ListNode hb = headB;
		while (hb != null) {
			stackA.push(hb);
			hb = hb.next;
		}
		
		ListNode p = null;
		while(!stackA.isEmpty() && !stackB.isEmpty()) {
			ListNode a = stackA.pop();
			ListNode b = stackB.pop();
			
			if(a.val != b.val) {
				return a;
			}
			p = a;
		}
		return p;
	}

}
