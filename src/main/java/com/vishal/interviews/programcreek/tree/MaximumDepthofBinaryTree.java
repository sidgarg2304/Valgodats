package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}
