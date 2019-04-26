package com.vishal.interviews.facebook.easy;

public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closestValue(TreeNode root, double target) {

		if (root == null) {
			return -1;
		}

		int res = root.val;

		TreeNode p = root;
		while (p != null) {

			if (Math.abs(p.val - target) < Math.abs(res - target)) {
				res = p.val;
			}

			if (target < p.val) {
				p = p.left;
			} else {
				p = p.right;
			}

		}
		return res;
	}

}
