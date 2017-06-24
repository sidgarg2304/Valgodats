package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class SameTree {

	public static void main(String[] args) {

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
