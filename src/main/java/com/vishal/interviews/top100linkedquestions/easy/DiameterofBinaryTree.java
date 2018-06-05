package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class DiameterofBinaryTree {

	public static void main(String[] args) {

	}

	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		maxDepth(root);
		return max;
	}

	int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}

}
