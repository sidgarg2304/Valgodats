package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.TreeNode;

public class DeleteNodeinaBST {

	public static void main(String[] args) {

	}

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			TreeNode rightMin = findMin(root.right);
			root.val = rightMin.val;
			deleteNode(root, rightMin.val);
		}

		return root;

	}

	TreeNode findMin(TreeNode root) {
		TreeNode p = root;
		while (p.left != null) {
			p = p.left;
		}

		return p;
	}

}
