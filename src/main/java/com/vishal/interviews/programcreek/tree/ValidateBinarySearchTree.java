package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isValidBSTMinMax(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBSTMinMax(root, min, root.val) && isValidBSTMinMax(root, root.val, max);

	}

}
