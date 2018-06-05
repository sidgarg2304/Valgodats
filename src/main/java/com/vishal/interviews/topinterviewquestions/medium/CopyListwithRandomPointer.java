package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.RandomListNode;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {

	}

	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode p = head;

		while (p != null) {
			RandomListNode cloneP = new RandomListNode(p.label);
			RandomListNode n = p.next;
			p.next = cloneP;
			cloneP.next = n;
			p = n;
		}

		p = head;
		while (p != null) {
			if (p.random != null) {
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}

		p = head;
		RandomListNode cloneHead = head.next;
		while (p != null) {
			RandomListNode clone = p.next;

			p.next = clone.next;

			if (p.next != null) {
				clone.next = p.next.next;
			}

			p = p.next;

		}

		return cloneHead;
	}
}
