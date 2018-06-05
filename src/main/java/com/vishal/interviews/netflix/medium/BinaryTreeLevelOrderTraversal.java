package com.vishal.interviews.netflix.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int s = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int l = 0; l < s; l++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}

			res.add(level);
		}
		
		return res;
	}

}
