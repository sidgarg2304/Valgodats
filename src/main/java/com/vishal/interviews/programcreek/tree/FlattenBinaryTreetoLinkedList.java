package com.vishal.interviews.programcreek.tree;

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
			TreeNode cur = stack.pop();

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}

			if (!stack.isEmpty()) {
				cur.right = stack.peek();
			}
		}
	}

}
