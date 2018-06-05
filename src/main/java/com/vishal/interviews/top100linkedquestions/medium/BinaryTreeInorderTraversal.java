package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode cur = stack.pop();
				res.add(cur.val);
				p = cur.right;
			}
		}
		return res;
	}

}
