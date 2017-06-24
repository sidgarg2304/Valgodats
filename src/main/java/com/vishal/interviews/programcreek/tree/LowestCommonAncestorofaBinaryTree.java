package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		TreeNode l = lowestCommonAncestor(root.left, p, q);
		TreeNode r = lowestCommonAncestor(root.right, p, q);

		if (l != null && r != null) {
			return root;
		} else {
			return l == null ? r : l;
		}
	}

}
