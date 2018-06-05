package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetric(root.left, root.right);
	}

	boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (l == null || r == null) {
			return false;
		}

		if (l.val != r.val) {
			return false;
		}

		return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
	}

}
