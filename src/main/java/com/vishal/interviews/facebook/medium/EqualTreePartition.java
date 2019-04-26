package com.vishal.interviews.facebook.medium;

import java.util.Stack;

public class EqualTreePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkEqualTree(TreeNode root) {

		if (root == null) {
			return false;
		}

		Stack<Integer> stack = new Stack<>();
		int total = sum(root, stack);
		stack.pop();
		if (total % 2 == 0) {
			while (!stack.isEmpty()) {
				if (stack.pop() == total / 2) {
					return true;
				}
			}
		}
		return false;

	}

	int sum(TreeNode root, Stack<Integer> stack) {
		if (root == null) {
			return 0;
		}
		stack.push(sum(root.left, stack) + sum(root.right, stack) + root.val);
		return stack.peek();
	}

}
