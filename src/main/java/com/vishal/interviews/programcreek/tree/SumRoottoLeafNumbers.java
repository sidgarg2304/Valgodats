package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {

	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		dfs(root, 1);
		return sum;
	}

	int sum = 0;

	void dfs(TreeNode root, int num) {

		num = num * 10 + root.val;

		if (root.left == null && root.right == null) {
			sum += num;
			return;
		}

		if (root.left != null) {
			dfs(root.left, num);
		}

		if (root.right != null) {
			dfs(root.right, num);
		}
	}

}
