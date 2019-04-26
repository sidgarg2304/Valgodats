package com.vishal.interviews.facebook.easy;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		return isSymmetric(root.left, root.right);

	}

	boolean isSymmetric(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		}
		
		if(left.val != right.val){
			return false;
		}
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

}
