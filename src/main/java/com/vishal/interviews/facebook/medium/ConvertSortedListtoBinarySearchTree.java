package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		ListNode p = null;
		while (fast != null && fast.next != null) {
			p = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);
		if (p != null) {
			p.next = null;
			root.left = sortedListToBST(head);
		}
		root.right = sortedListToBST(slow.next);

		return root;

	}

}
