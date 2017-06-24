package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class FindLeavesofBinaryTree {

	public static void main(String[] args) {

	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		height(root, map);

		res.addAll(map.values());

		return res;
	}

	int height(TreeNode root, Map<Integer, List<Integer>> map) {

		if (root == null) {
			return 0;
		}

		int l = height(root.left, map);
		int r = height(root.left, map);

		int h = Math.max(l, r) + 1;

		if (!map.containsKey(h)) {
			map.put(h, new ArrayList<>());
		}

		map.get(h).add(root.val);

		return h;
	}
}
