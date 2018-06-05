package com.vishal.interviews.top100linkedquestions.easy;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode left = cur.left;
			TreeNode right = cur.right;

			cur.left = right;
			cur.right = left;

			if (left != null) {
				queue.offer(left);
			}

			if (right != null) {
				queue.offer(right);
			}
		}

		return root;

	}

}
