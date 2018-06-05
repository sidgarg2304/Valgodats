package com.vishal.interviews.top100linkedquestions.medium;

import com.vishal.interviews.util.TreeNode;

public class HouseRobberIII {

	public static void main(String[] args) {

	}

	public int rob(TreeNode root) {

		int[] res = robHelper(root);

		return Math.max(res[0], res[1]);
	}

	int[] robHelper(TreeNode root) {
		int[] res = new int[2];

		if (root == null) {
			return res;
		}

		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);
		
		res[0] = root.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return res;

	}

}
