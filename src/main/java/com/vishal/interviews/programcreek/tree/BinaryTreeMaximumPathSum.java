package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		currentPathSum(root);
		return max;

	}

	int currentPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);

		int current = Math.max(Math.max(left + root.val, right + root.val), root.val);
		max = Math.max(max, Math.max(current, root.val + left + right));
		

		return current;
	}

}
