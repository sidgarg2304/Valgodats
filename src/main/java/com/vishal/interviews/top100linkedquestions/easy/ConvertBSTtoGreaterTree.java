package com.vishal.interviews.top100linkedquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class ConvertBSTtoGreaterTree {

	public static void main(String[] args) {

	}

	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		convertBST(root.right);
		
		sum += root.val;
		root.val = sum;
		
		convertBST(root.left);
		
		return root;
	}

}
