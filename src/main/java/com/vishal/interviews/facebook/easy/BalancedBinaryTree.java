package com.vishal.interviews.facebook.easy;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		if (Math.abs(l - r) > 1) {
			return -1;
		}

		return 1 + Math.max(l, r);
	}

}
