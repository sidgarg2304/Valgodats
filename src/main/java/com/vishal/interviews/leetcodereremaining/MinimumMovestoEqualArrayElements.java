package com.vishal.interviews.leetcodereremaining;

public class MinimumMovestoEqualArrayElements {

	public static void main(String[] args) {

	}

	public int minMoves(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int res = 0;
		int min = nums[0];
		for (int i : nums) {
			min = Math.min(min, i);
		}

		for (int i : nums) {
			res += i - min;
		}

		return res;
	}

}
