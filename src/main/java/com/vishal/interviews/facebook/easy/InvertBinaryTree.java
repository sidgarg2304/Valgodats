package com.vishal.interviews.facebook.easy;

public class InvertBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode invLeft = invertTree(root.left);
		TreeNode invRight = invertTree(root.right);

		root.left = invRight;
		root.right = invLeft;

		return root;
	}

}
