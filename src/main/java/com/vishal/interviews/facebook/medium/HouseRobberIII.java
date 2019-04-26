package com.vishal.interviews.facebook.medium;


public class HouseRobberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rob(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return Math.max(robIncludeRoot(root), robExcludeRoot(root));
	}

	int robIncludeRoot(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val + robExcludeRoot(root.left) + robExcludeRoot(root.right);

	}

	int robExcludeRoot(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return rob(root.left) + rob(root.right);
	}

}
