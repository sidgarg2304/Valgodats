package com.vishal.interviews.facebook.medium;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int res = 0;

	public int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}

		dfs(root, "");
		return res;
	}

	void dfs(TreeNode root, String cur) {
		if (root == null) {
			return;
		}

		cur += root.val;

		if (root.left == null && root.right == null) {
			res += Integer.parseInt(cur);
			return;
		}

		dfs(root.left, cur);
		dfs(root.right, cur);
	}

}
