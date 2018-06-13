package com.vishal.interviews.salesforce;

import com.vishal.interviews.util.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterofBinaryTree {

	public static void main(String[] args) {

	}
	
	int diameter(TreeNode root){
		
		maxDepth(root);
		return max;
	}

	static int max = 0;

	static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = maxDepth(root.left);
		int r = maxDepth(root.right);

		max = Math.max(l + r, max);

		return Math.max(l, r) + 1;
	}

}

