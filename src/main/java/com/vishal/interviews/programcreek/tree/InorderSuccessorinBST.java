package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class InorderSuccessorinBST {

	public static void main(String[] args) {

	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {		

		TreeNode cur = root;

		TreeNode res = null;
		while (cur != null) {
			if (p.val < cur.val) {
				res = cur;
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return res;

	}

}
