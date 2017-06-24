package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class LevelOrderII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				temp.add(cur.val);

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(0, temp);
		}
		return res;
	}

}
