package com.vishal.interviews.facebook.careercup;

import com.vishal.interviews.util.TreeNode;

/**
 * You have a binary tree which consists of 0 or 1 in the way, that each node value is a LOGICAL AND between its children:


     0
   /   \
  0     1
 / \   / \
0   1  1  1
You need to write a code, which will invert given LEAF and put tree in a correct state.
 *
 */
public class LogicalAndBinaryTree {

	public static void main(String[] args) {

	}

	static void updateTree(TreeNode root, TreeNode leaf) {
		
		if(root == null){
			return;
		}
		if (root.left == null && root.right == null) {
			if (root == leaf) {
				root.val ^= 3;				
			}			
		}
		updateTree(root.left, leaf);
		updateTree(root.right, leaf);

		root.val = root.left.val & root.right.val;
		
	}

}
