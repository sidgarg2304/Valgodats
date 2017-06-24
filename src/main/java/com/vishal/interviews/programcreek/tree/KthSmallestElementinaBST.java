package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class KthSmallestElementinaBST {

	public static void main(String[] args) {

	}

	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode cur = stack.pop();
				k--;
				if (k == 0) {
					return cur.val;
				}
				p = cur.right;
			}
		}

		return 0;
	}

}
