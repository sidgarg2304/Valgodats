package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {

	}

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		inorder(root);

		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}

	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	TreeNode first;
	TreeNode second;

	void inorder(TreeNode root) {

		if (root == null) {
			return;
		}

		inorder(root.left);

		if (first == null && prev.val >= root.val) {
			first = root;
		}

		if (first != null && prev.val >= root.val) {
			second = root;
		}

		prev = root;
		inorder(root.right);
	}

}
