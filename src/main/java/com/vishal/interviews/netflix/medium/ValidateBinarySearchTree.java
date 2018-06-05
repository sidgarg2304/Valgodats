package com.vishal.interviews.netflix.medium;

import com.vishal.interviews.util.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}

	boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root, min, root.val) && isValidBST(root, root.val, max);

	}

}
