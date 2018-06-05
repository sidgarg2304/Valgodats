package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.TreeNode;

public class InorderSuccessorinBST {

	public static void main(String[] args) {

	}

	//      5
	//  3      8
	// 2  4  6   
   //     
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		TreeNode c = root;

		TreeNode res = null;
		while (c != null) {
			if (p.val < c.val) {
				res = c;
				c = c.left;
			} else {
				c = c.right;
			}
		}
		return res;
	}

}
