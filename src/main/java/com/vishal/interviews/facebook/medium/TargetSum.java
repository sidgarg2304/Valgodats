package com.vishal.interviews.facebook.medium;

/**
 * 494. Target Sum
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 */
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int ct = 0;
   public int findTargetSumWays(int[] nums, int target) {
       dfs(nums, 0, target);
		return ct;
   }
   
   void dfs(int[] nums, int p, int target) {

		if (p == nums.length) {
			if (0 == target) {
				ct++;
			}
			return;
		}

		dfs(nums, p + 1, target - nums[p]);
		dfs(nums, p + 1, target + nums[p]);
	}
}
