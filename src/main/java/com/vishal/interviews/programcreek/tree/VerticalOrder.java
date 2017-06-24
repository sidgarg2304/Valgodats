package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class VerticalOrder {

	public static void main(String[] args) {

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<>());
			}

			map.get(col).add(cur.val);

			min = Math.min(col, min);
			max = Math.max(col, max);

			if (cur.left != null) {
				queue.offer(cur.left);
				cols.offer(col - 1);
			}

			if (cur.right != null) {
				queue.offer(cur.right);
				cols.offer(col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

}
