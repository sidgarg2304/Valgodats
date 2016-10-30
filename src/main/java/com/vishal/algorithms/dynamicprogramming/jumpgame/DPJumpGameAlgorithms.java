package com.vishal.algorithms.dynamicprogramming.jumpgame;

import java.util.Arrays;

public class DPJumpGameAlgorithms {

	public static void main(String[] args) {
		testCanReachEnd();
		testMinNumofJumps();
	}

	public static void testCanReachEnd() {
		System.out.println("2,3,1,1,4 " + (canReachEnd(new int[] { 2, 3, 1, 1, 4 }) ? "can" : "cannot") + " reach end");
		System.out.println("3,2,1,0,4 " + (canReachEnd(new int[] { 3, 2, 1, 0, 4 }) ? "can" : "cannot") + " reach end");
	}

	public static void testMinNumofJumps() {
		System.out.println(
				"min number of jumps to reach end is " + minNumofJumps(new int[] { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 }));
	}

	public static boolean canReachEnd(int[] jumps) {
		int maxJump = jumps[0];

		for (int i = 0; i < jumps.length; i++) {
			// if current value is 0 and previous max cannot cross current position
			if (jumps[i] == 0 && maxJump <= i) {
				return false;
			}

			maxJump = Math.max(maxJump, jumps[i] + i);

			if (maxJump >= jumps.length - 1) {
				return true;
			}
		}

		return false;
	}

	public static int minNumofJumps(int[] jumps) {
		int[] dp = new int[jumps.length];
		int[] pos = new int[jumps.length];
		pos[0] = -1;
		for (int i = 1; i < jumps.length; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
			for (int j = 0; j < i; j++) {
				if (j + jumps[j] >= i) {
					if (dp[j] + 1 < dp[i]) {
						dp[i] = dp[j] + 1;
						pos[i] = j;
					}
				}
			}
		}

		System.out.println(Arrays.toString(pos));

		StringBuilder res = new StringBuilder();
		int element = jumps.length - 1;
		while (element >= 0) {
			res.append(String.valueOf(element) + "<-");
			element = pos[element];
		}
		System.out.println(res);
		return dp[jumps.length - 1];
	}

}
