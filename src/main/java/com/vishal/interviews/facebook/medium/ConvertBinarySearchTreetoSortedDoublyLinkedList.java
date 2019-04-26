package com.vishal.interviews.facebook.medium;

import java.util.Stack;

import com.vishal.interviews.util.TreeNode;;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * 
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:

We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
 *
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

	public static void main(String[] args) {
	}
	
	public TreeNode treeToDoublyList(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode dummy = new TreeNode(-1);

		TreeNode prev = dummy;
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				prev.right = cur;
				cur.left = prev;
				prev = cur;
				cur = cur.right;
			}
		}
		dummy.right.left = prev;
		prev.right = dummy.right;

		return dummy.right;

	}

}
