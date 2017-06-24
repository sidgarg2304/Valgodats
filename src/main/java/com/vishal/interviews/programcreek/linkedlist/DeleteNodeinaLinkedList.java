package com.vishal.interviews.programcreek.linkedlist;

import com.vishal.interviews.util.ListNode;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {

	}

	public void deleteNode(ListNode node) {
		if (node.next == null) {
			node = null;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
