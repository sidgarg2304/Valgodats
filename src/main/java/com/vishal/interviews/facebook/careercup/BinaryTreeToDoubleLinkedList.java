package com.vishal.interviews.facebook.careercup;

import com.vishal.interviews.util.DListNode;
import com.vishal.interviews.util.TreeNode;

/**
 * Question 1: Binary tree to doubly linked list.
 * 
 *     8
   4      12
1    6  10 


1 -> 4 -> 6 -> 8 -> 10 -> 12
 *
 */
public class BinaryTreeToDoubleLinkedList {

	public static void main(String[] args) {

	}

	DListNode bTreeToList(TreeNode root) {
		if (root == null) {
			return null;
		}

		DListNode cur = new DListNode(root.val);

		DListNode left = bTreeToList(root.left);
		DListNode right = bTreeToList(root.right);

		if (left == null && right == null) {
			cur.next = cur;
			cur.pre = cur;
			return cur;
		}

		if (left == null) {

			DListNode rTail = right.pre;
			right.pre = cur;
			cur.next = right;
			cur.pre = rTail;
			rTail.next = cur;

		} else if (right == null) {

			DListNode lTail = left.pre;
			lTail.next = cur;
			cur.pre = lTail;
			left.pre = cur;
			cur.next = left;

		} else {
			DListNode rTail = right.pre;
			DListNode lTail = left.pre;

			cur.pre = lTail;
			cur.next = right;
			right.pre = cur;
			lTail.next = cur;

			left.pre = rTail;
			rTail.next = left;
		}

		return left != null ? left : cur;

	}

}
