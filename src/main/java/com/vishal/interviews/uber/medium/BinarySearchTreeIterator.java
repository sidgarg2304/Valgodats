package com.vishal.interviews.uber.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {

	}

	Stack<TreeNode> stack;

	BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<>();

		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}

	int next() {
		TreeNode cur = stack.pop();

		TreeNode p = cur.right;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		return cur.val;
	}

	boolean hasNext() {
		return !stack.isEmpty();
	}

}
