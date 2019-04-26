package com.vishal.interviews.facebook.medium;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int a = 1; a <= amount; a++) {
			dp[a] = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) {
				if (a - coins[i] >= 0 && dp[a-coins[i]] != Integer.MAX_VALUE) {				
					dp[a] = Math.min(dp[a], dp[a - coins[i]] + 1);
				}
			}
		}

		if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
		
		return dp[amount];
	}

}
