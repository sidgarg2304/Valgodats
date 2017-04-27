package com.vishal.interviews.linkedin.medium;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of 
nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {

	}

	static TreeNode lcsBT(TreeNode root, int a, int b) {

		if (root == null) {
			return null;
		}

		if (root.val == a || root.val == b) {
			return root;
		}

		TreeNode l = lcsBT(root.left, a, b);
		TreeNode r = lcsBT(root.right, a, b);

		if (l != null && r != null) {
			return root;
		} else if (l == null && r == null) {
			return null;
		} else {
			return l == null ? r : l;
		}

	}

	static int lcaBST(TreeNode root, int a, int b) {

		if (root == null) {
			return -1;
		}

		if (a < root.val && b > root.val) {
			return root.val;
		} else if (a > root.val && b > root.val) {
			return lcaBST(root.right, a, b);
		} else if (a < root.val && b < root.val) {
			return lcaBST(root.left, a, b);
		}

		return root.val;

	}

}
