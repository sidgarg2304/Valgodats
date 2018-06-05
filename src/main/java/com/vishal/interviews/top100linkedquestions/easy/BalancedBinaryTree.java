package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = height(root.left);
		int r = height(root.right);

		if (l == -1 || r == -1) {
			return -1;
		}

		int diff = Math.abs(l - r);
		if (diff > 1) {
			return -1;
		}

		return 1 + Math.max(l, r);
	}

}
