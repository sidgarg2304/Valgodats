package com.vishal.interviews.programcreek.dynamicprogramming;

import java.util.Arrays;

public class JumpGameII {

	public static void main(String[] args) {

		// System.out.println(jump(new int[] { 3, 2, 1 }));
		System.out.println(jump(new int[] { 2, 1, 2, 3 }));
	}

	/**
	 * For example, given array A = [2,3,1,1,4], the minimum number of jumps to
	 * reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to
	 * the last index.)
	 * 
	 * @return
	 */

	public static int jump(int[] nums) {
		int res = 0;
		int e = 0;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == e) {
				res++;
				e = max;
			}
		}
		return res;
	}

	public static int jumpDP(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int[] dp = new int[nums.length];
		dp[0] = 0;

		for (int i = 1; i < nums.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {

				if (j + nums[j] >= i) {
					if ((dp[j] + 1) < dp[i]) {
						System.out.println("udpating dp " + j + " with " + (dp[j] + 1));
					}
					dp[i] = Math.min(dp[j] + 1, dp[i]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));

		return dp[nums.length - 1];

	}

}
