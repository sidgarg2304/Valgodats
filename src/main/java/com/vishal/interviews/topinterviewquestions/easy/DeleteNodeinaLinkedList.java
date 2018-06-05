package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.ListNode;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {

	}

	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		if (node.next == null) {
			node = null;
			return;
		}

		node.val = node.next.val;
		node.next = node.next.next;		
	}
}
