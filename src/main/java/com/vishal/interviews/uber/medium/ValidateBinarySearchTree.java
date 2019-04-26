package com.vishal.interviews.uber.medium;

import com.vishal.interviews.util.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {        				
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	public boolean isValidBST(TreeNode root, long min, long max){
		if(root == null){
			return true;
		}
		
		if(root.val <= min || root.val >= max){
			return false;
		}
		
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

}
