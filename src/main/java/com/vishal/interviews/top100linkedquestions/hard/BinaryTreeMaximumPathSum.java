package com.vishal.interviews.top100linkedquestions.hard;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		dfs(root);
		return max;
	}

	int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = dfs(root.left);
		int right = dfs(root.right);

		int curMax = Math.max(Math.max(root.val, left + root.val), right + root.val);
		max = Math.max(max, Math.max(curMax, left + root.val + right));

		return curMax;

	}

}
