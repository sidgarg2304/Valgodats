package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class Preorder {

	public static void main(String[] args) {

	}

	void preorder(TreeNode root) {
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}

	List<Integer> preorderIter(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}

		return res;
	}
}
