package com.vishal.interviews.facebook.careercup;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

/**
 * Given a binary tree of integers, write code to store the tree into a list of
 * integers and recreate the original tree from a list of integers.
 *
 */
public class EncodeAndDecodeBinaryTreeAsList {

	public static void main(String[] args) {

	}

	List<Integer> store(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (queue.isEmpty()) {
			TreeNode c = queue.poll();
			if (c == null) {
				res.add(null);
			} else {
				res.add(c.val);
				queue.offer(c.left);
				queue.offer(c.right);
			}
		}

		return res;
	}

	TreeNode restore(List<Integer> list) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(list.get(0));

		int r = 0;
		while (!queue.isEmpty()) {
			TreeNode c = queue.poll();
			Integer left = list.get(r++);
			Integer right = list.get(r++);

			if (left != null) {
				c.left = new TreeNode(left);
				queue.offer(c.left);
			}

			if (right != null) {
				c.right = new TreeNode(right);
				queue.offer(c.right);
			}
		}

		return root;
	}

}
