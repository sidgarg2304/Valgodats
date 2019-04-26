package com.vishal.interviews.facebook.easy;

import java.util.*;

public class IncreasingOrderSearchTree {

	public static void main(String[] args) {

	}

	public TreeNode increasingBST(TreeNode root) {

		if (root == null) {
			return null;
		}
		TreeNode res = new TreeNode(-1);

		TreeNode r = res;
		Stack<TreeNode> stack = new Stack<>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode c = stack.pop();
				p = c.right;
				r.right = c;
				r = r.right;
				r.left = null;
			}
		}

		return res.right;

	}

}
