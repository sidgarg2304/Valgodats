package com.vishal.interviews.leetcodereremaining;

import com.vishal.interviews.linkedin.util.TreeNode;

public class BinaryTreeTilt {

	public static void main(String[] args) {

	}

	int res = 0;

	public int findTilt(TreeNode root) {

		if (root == null) {
			return 0;
		}

		helper(root);

		return res;
	}

	int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = helper(root.left);
		int r = helper(root.right);

		res += Math.abs(l - r);

		return l + r + root.val;
	}

}
