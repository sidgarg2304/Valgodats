package com.vishal.interviews.facebook.hard;

import com.vishal.interviews.util.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode first = null;
	TreeNode sec = null;

	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		inOrder(root);
		if(first != null && sec != null) {
			int secVal = sec.val;
			sec.val = first.val;
			first.val = secVal;
		}
	}

	void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);		

		if (first == null && root.val <= prev.val) {
			first = prev;
		}

		if (first != null && root.val <= prev.val) {
			sec = root;
		}
        
        prev = root;

		inOrder(root.right);
	}

}
