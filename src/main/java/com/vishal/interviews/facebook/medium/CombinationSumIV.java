package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 377. Combination Sum IV
 * 
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 *
 */
public class CombinationSumIV {

	public static void main(String[] args) {

		System.out.println(combinationSum4DPBottomDown(new int[]{1,2,3}, 4));
	}

	public static int combinationSum4Rec(int[] nums, int target) {

		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += combinationSum4Rec(nums, target - nums[i]);
			}
		}

		return res;
	}
	
	public static int combinationSum4DP(int[] nums, int target) {

		int[] dp = new int[target+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 1;
		dfs(nums, target, dp);
		return dp[target];
	}
	
	static int dfs(int[] nums, int target, int[] dp){
		if(dp[target] != -1){
			return dp[target];
		}
				
		
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += dfs(nums, target - nums[i], dp);
			}
			
		}
		dp[target] = res; 

		return res;
		
	}
	
	public static int combinationSum4DPBottomDown(int[] nums, int target) {

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int sum = 1; sum <= target; sum++) {
			for (int j = 0; j < nums.length; j++) {
				if (sum - nums[j] >= 0) {
					dp[sum] += dp[sum - nums[j]];
				}
			}
		}
		return dp[target];
	}

}
