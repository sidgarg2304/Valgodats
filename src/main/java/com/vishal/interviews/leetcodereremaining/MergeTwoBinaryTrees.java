package com.vishal.interviews.leetcodereremaining;

import com.vishal.interviews.util.TreeNode;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {

	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		} else if (t1 == null || t2 == null) {
			return t1 == null ? t2 : t1;
		}

		TreeNode newRoot = new TreeNode(t1.val + t2.val);
		newRoot.left = mergeTrees(t1.left, t2.left);
		newRoot.right = mergeTrees(t1.right, t2.right);

		return newRoot;
	}

}
