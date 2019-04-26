package com.vishal.interviews.facebook.hard;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {

		if(root == null) {
			return 0;
		}
		maxPath(root);
		return max;
		
	}
	
	int maxPath(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = maxPath(root.left);
		int right = maxPath(root.right);
		
		int curMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
		
		max = Math.max(max, Math.max(curMax, left + right + root.val));
		
		return curMax;
	}
}
