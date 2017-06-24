package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

}
