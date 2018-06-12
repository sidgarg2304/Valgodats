package com.vishal.interviews.salesforce;

import java.util.*;

public class BreathFirstSearch {

	public static void main(String[] args) {

	}

	static List<List<Integer>> bfs(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);
				for (TreeNode ch : cur.children) {
					queue.offer(ch);
				}
			}
			res.add(level);
		}
		return res;
	}

}

class TreeNode {
	int val;
	List<TreeNode> children;
}
