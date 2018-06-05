package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}

	public boolean isValidBST(TreeNode root) {

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, int l, int h) {
		if (root == null) {
			return true;
		}

		if (root.val <= l || root.val >= h) {
			return false;
		}

		return isValidBST(root.left, l, root.val) && isValidBST(root.right, root.val, h);
	}

}
