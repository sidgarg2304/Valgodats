package com.vishal.interviews.salesforce;

import java.util.*;

import com.vishal.interviews.util.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode r = getIntersectionNodeUsingStack(one, one);
		System.out.println(r.val);
	}

	public static ListNode getIntersectionNodeUsingStack(ListNode headA, ListNode headB) {

		Stack<ListNode> stackA = new Stack<>();
		Stack<ListNode> stackB = new Stack<>();

		ListNode a = headA;
		while (a != null) {
			stackA.push(a);
			a = a.next;
		}

		ListNode b = headB;
		while (b != null) {
			stackB.push(b);
			b = b.next;
		}

		ListNode p = null;
		while (!stackA.isEmpty() && !stackB.isEmpty()) {
			a = stackA.pop();
			b = stackB.pop();
			if (a.val != b.val) {
				break;
			} else {
				System.out.println("setting p " + a.val);
				p = a;
			}
		}
		return p;

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = 0;
		ListNode a = headA;
		while (a != null) {
			lenA++;
			a = a.next;
		}

		int lenB = 0;
		ListNode b = headB;
		while (b != null) {
			lenB++;
			b = b.next;
		}

		int d = Math.abs(lenA - lenB);

		ListNode h = lenA > lenB ? headA : headB;
		for (int i = 0; i < d; i++) {
			h = h.next;
		}

		ListNode s = lenA < lenB ? headA : headB;

		while (h != null && s != null) {
			if (h.val == s.val) {
				return h;
			}
			s = s.next;
			h = h.next;
		}
		return null;

	}

}
