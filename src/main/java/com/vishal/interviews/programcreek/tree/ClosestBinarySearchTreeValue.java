package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {

	}

	public int closestValue(TreeNode root, double target) {
		int res = root.val;

		TreeNode p = root;

		while (p != null) {
			if (Math.abs(root.val - target) < Math.abs(res - target)) {
				res = root.val;
			}
			if (target < root.val) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return res;

	}

}
