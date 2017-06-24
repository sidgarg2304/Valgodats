package com.vishal.interviews.leetcodereremaining.medium;

import com.vishal.interviews.util.TreeNode;

public class ConvertBSTtoGreaterTree {

	public static void main(String[] args) {

	}

	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}

		convertBST(root.right);

		root.val += (root.right != null ? root.right.val : 0);

		convertBST(root.left);

		if (root.left != null) {
			root.left.val += root.val;
		}

		return root;
	}

}
