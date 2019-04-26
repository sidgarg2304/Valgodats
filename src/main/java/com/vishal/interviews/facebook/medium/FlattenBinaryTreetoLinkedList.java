package com.vishal.interviews.facebook.medium;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		TreeNode res = new TreeNode(-1);
		TreeNode r = res;
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode c = stack.pop();

			if (c.right != null) {
				stack.push(c.right);
			}
			
			if (c.left != null) {
				stack.push(c.left);
			}			

			r.right = c;
			c.left = null;
			r = r.right;
		}

	}

}
