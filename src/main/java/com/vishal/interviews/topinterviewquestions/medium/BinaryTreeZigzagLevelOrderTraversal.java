package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		boolean rev = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> cur = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode c = queue.poll();
				if (rev) {
					cur.add(0, c.val);
				} else {
					cur.add(c.val);
				}

				if (c.left != null) {
					queue.offer(c.left);
				}

				if (c.right != null) {
					queue.offer(c.right);
				}
			}
			res.add(cur);
			rev = !rev;
		}
		return res;
	}

}
