package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class MostFrequentSubtreeSum {

	public static void main(String[] args) {

	}

	public int[] findFrequentTreeSum(TreeNode root) {

		Map<Integer, Integer> map = new HashMap<>();

		pathSum(root, map);
		List<Integer> res = new ArrayList<>();

		for (int sum : map.keySet()) {
			if (map.get(sum) == maxCount) {
				res.add(sum);
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}

	int maxCount;

	int pathSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}

		int curSum = root.val;

		curSum += pathSum(root.left, map);
		curSum += pathSum(root.right, map);
		map.put(curSum, map.getOrDefault(curSum, 0) + 1);

		maxCount = Math.max(maxCount, map.get(curSum));
		return curSum;
	}

}
