package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return -1 != getHeight(root);
	}

	int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = getHeight(root.left);
		int r = getHeight(root.right);

		if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
			return -1;
		}

		return 1 + Math.max(l, r);
	}
}
