package com.vishal.interviews.top100linkedquestions.easy;

import java.util.HashMap;
import java.util.Map;

import com.vishal.interviews.util.TreeNode;

public class PathSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, -1);

		return dfs(root, sum, 0, preSum);

	}

	int dfs(TreeNode root, int sum, int curSum, Map<Integer, Integer> preSum) {
		if (root == null) {
			return 0;
		}

		curSum += root.val;
		int res = preSum.getOrDefault(curSum - sum, 0);

		preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

		res += dfs(root.left, sum, curSum, preSum);
		res += dfs(root.right, sum, curSum, preSum);

		return res;

	}

}
