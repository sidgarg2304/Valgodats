package com.vishal.interviews.linkedin.careercup;

import com.vishal.interviews.linkedin.util.TreeNode;

/**
 * /** 
* A tournament tree is a binary tree 
* where the parent is the minimum of the two children. 
* Given a tournament tree find the second minimum value in the tree. 
* A node in the tree will always have 2 or 0 children. 
* Also all leaves will have distinct and unique values. 
* 2 
* / \ 
* 2 3 
* / \ | \ 
* 4 2 5 3 
* 
* In this given tree the answer is 3. 
 */
public class TournamentSecondMin {

	public static void main(String[] args) {

	}

	public int secondMin(TreeNode root) {
		if (root == null) {
			return 0;
		}

		TreeNode p = root;

		int res = Integer.MAX_VALUE;
		while (p.left != null && p.right != null) {
			if (p.val == p.left.val) {
				res = Math.min(res, p.right.val);
				p = p.left;
			} else {
				res = Math.min(res, p.left.val);
				p = p.right;
			}
		}
		
		return res == Integer.MAX_VALUE ? 0 : res;
	}

}
