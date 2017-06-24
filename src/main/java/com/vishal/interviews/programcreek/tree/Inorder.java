package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class Inorder {

	public static void main(String[] args) {

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			p = cur.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
		return res;
	}

}
