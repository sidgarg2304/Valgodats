package com.vishal.interviews.salesforce;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxAreaOfSquare(int[][] nums){
		int[][] dp = new int[nums.length+1][nums[0].length+1];
		
		int res = 0;
		for(int i = 1; i< dp.length; i++){
			for(int j = 1; j< dp[0].length; j++){
				if(nums[i-1][j-1] == 1){
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res * res;
	}

}
