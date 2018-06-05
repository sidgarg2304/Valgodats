package com.vishal.interviews.topinterviewquestions.hard;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}

		curPathSum(root);
		return max;

	}

	int curPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = curPathSum(root.left);
		int right = curPathSum(root.right);

		int curMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
		
		max = Math.max(max, Math.max(curMax, left + right + root.val));
		
		return curMax;
	}

}
