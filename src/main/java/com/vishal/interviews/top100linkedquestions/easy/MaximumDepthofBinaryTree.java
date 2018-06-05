package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}

}
