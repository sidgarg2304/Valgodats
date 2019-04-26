package com.vishal.interviews.facebook.medium;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums) {
      if(nums == null || nums.length == 0){
			return 0;
		}
      int res = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
          dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					res = Math.max(dp[i], res);
				}
			}
		}
		return res;
  }

}
