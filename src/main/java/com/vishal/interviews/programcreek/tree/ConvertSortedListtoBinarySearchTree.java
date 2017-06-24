package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.ListNode;
import com.vishal.interviews.util.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		return sortedListToBST(head, null);
	}

	public TreeNode sortedListToBST(ListNode start, ListNode end) {

		if (start == end) {
			return null;
		}
		ListNode slow = start;
		ListNode fast = start;

		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);

		root.left = sortedListToBST(start, slow);
		root.right = sortedListToBST(slow.next, end);

		return root;

	}

}
