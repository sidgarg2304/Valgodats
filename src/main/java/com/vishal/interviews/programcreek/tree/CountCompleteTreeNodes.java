package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {

	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int l = getLeftHeight(root.left) + 1;
		int r = getRightHeight(root.right) + 1;

		if (l == r) {
			return (1 << l) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}

	}

	int getLeftHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		TreeNode p = root;
		while (p != null) {
			p = p.left;
			res++;

		}

		return res;

	}

	int getRightHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		TreeNode p = root;
		while (p != null) {
			p = p.right;
			res++;

		}

		return res;
	}
}
