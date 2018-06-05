package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

	}

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode c = root;

			TreeNode l = c.left;
			TreeNode r = c.right;

			if (r != null) {
				stack.push(r);
			}

			if (l != null) {
				stack.push(l);
			}
			c.right = stack.peek();
			c.left = null;
		}

	}

}
