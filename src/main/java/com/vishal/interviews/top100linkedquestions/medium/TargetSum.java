package com.vishal.interviews.top100linkedquestions.medium;

public class TargetSum {

	public static void main(String[] args) {

	}

	int cnt = 0;

	public int findTargetSumWays(int[] nums, int target) {

		dfs(nums, target, 0);
		return cnt;
	}

	void dfs(int[] nums, int target, int p) {
		if (p == nums.length) {
			if (target == 0) {
				cnt++;
			}
			return;
		}

		dfs(nums, target - nums[p], p + 1);
		dfs(nums, target - nums[p], p - 1);
	}

}
