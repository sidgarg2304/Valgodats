package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class KthSmallestElementinaBST {

	public static void main(String[] args) {

	}

	public int kthSmallest(TreeNode root, int k) {

		if (root == null) {
			return -1;
		}
		Stack<TreeNode> stack = new Stack<>();

		TreeNode c = root;
		while (c != null || !stack.isEmpty()) {
			if (c != null) {
				stack.push(c);
				c = c.left;
			} else {
				TreeNode cur = stack.pop();
				k--;
				if (k == 0) {
					return cur.val;
				}
				c = cur.right;
			}
		}
		return -1;

	}

}
