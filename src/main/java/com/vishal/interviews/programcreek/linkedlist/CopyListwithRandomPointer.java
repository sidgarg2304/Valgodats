package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.RandomListNode;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {

	}

	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}

		RandomListNode p = head;

		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}

		p = head;
		while (p != null) {
			if (p.random != null) {
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}

		p = head;
		RandomListNode clonedHead = p.next;

		while (p != null) {
			RandomListNode clone = p.next;
			p.next = clone.next;

			if (clone.next != null) {
				clone.next = clone.next.next;
			}

			p = p.next;
		}

		return clonedHead;
	}

}
