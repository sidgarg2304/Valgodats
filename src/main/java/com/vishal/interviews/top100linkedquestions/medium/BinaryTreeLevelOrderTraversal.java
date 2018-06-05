package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int s = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < s; i++) {
				TreeNode c = queue.poll();
				temp.add(c.val);

				if (c.left != null) {
					queue.offer(c.left);
				}

				if (c.right != null) {
					queue.offer(c.right);
				}
			}
			res.add(temp);

		}

		return res;
	}

}
