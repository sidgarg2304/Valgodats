package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.TreeNode;

public class CountUnivalueSubtrees {

	public static void main(String[] args) {

		
	}

	int count;

	public int countUnivalSubtrees(TreeNode root) {

		helper(root);

		return count;
	}

	boolean helper(TreeNode root) {

		if (root == null) {
			return true;
		}

		boolean left = helper(root.left);
		boolean right = helper(root.right);

		if (left && right) {
			if (root.left != null && root.val != root.left.val) {
				return false;
			}

			if (root.right != null && root.val != root.right.val) {
				return false;
			}

			count++;
			return true;
		}
		return false;

	}
}
