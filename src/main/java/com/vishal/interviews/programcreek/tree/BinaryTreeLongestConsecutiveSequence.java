package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {

	}

	public int longestConsecutive(TreeNode root) {

		if (root == null) {
			return 0;
		}

		dfs(root, 1);

		return max;
	}

	int max = 1;

	void dfs(TreeNode root, int cur) {

		if (root == null) {
			return;
		}
		max = Math.max(cur, max);

		if (root.left != null) {
			if (root.left.val - root.val == 1) {
				dfs(root.left, cur + 1);
			} else {
				dfs(root.left, 1);
			}
		}

		if (root.right != null) {
			if (root.right.val - root.val == 1) {
				dfs(root.right, cur + 1);
			} else {
				dfs(root.right, 1);
			}
		}

	}

}
