package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class Postorder {

	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversalSimpleIterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(0, cur.val);

			if (cur.left != null) {
				stack.push(cur.left);
			}

			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();

		TreeNode c = root;

		while (c != null || !stack.isEmpty()) {
			if (c != null) {
				stack.push(c);
				c = c.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp != null) {
					c = temp;
				} else {
					temp = stack.pop();
					res.add(temp.val);

					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						res.add(temp.val);
					}
				}
			}
		}

		return res;
	}

}
