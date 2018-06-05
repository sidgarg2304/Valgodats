package com.vishal.interviews.nestlabs;

import com.vishal.interviews.util.TreeNode;

/**
 * 
 * Given a binary tree and a number, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given
 * number. Return false if no such path can be found.
 *
 */
public class SumRoottoLeafNumbers {

	public static void main(String[] args) {

	}	

	public boolean sumNumbers(TreeNode root, int x) {

		return dfs(root, 0, x);

	}

	boolean dfs(TreeNode root, int num, int x) {
		if (root == null) {
			return false;
		}

		num *= 10;
		num += root.val;

		if (root.left == null && root.right == null) {			
			return (num == x);
		}

		if (dfs(root.left, num, x)) {
			return true;
		}
		return dfs(root.right, num, x);
	}

}
