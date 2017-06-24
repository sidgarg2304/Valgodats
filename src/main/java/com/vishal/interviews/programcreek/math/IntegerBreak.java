package com.vishal.interviews.programcreek.math;

import java.util.Arrays;

public class IntegerBreak {

	public static void main(String[] args) {

		System.out.println(integerBreak(10));
	}

	public static int integerBreak(int n) {
		int[] dp = new int[n + 1];

		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i; j++) {

				// We can split i as j & i-j: For Eg: 4 can be split as 1,3 or 2,2
				// Do you want to use this split values and take product or do you
				// want to further split each value and take their products
				// or do you want to further split one part and use other directly? 
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}

		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

}
