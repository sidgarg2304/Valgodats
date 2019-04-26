package com.vishal.interviews.uber.hard;

import java.util.Arrays;

public class CherryPickup {

	public static void main(String[] args) {

	}

	int[][][] dp;
	int[][] grid;
	int n;

	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		dp = new int[n][n][n];
		this.grid = grid;
		this.n = n;

		for (int[][] level : dp) {
			for (int[] row : level) {
				Arrays.fill(row, Integer.MIN_VALUE);
			}
		}

		return Math.max(0, helper(0, 0, 0));
	}

	public int helper(int r1, int c1, int c2) {

		int r2 = r1 + c1 - c2;

		if (r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		} else if (r1 == n - 1 && c1 == n - 1) {
			return grid[r1][c1];
		} else if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
			return dp[r1][c1][c2];
		}

		int res = grid[r1][c1];
		if (c1 != c2) {
			res += grid[r2][c2];
		}
		int max = Integer.MIN_VALUE;
		max = Math.max(max, helper(r1, c1 + 1, c2 + 1)); // both moving right direction
		max = Math.max(max, helper(r1 + 1, c1, c2)); // both moving down direction
		max = Math.max(max, helper(r1 + 1, c1, c2 + 1)); // person1 moving down and person2 moving right
		max = Math.max(max, helper(r1, c1 + 1, c2)); // person1 moving right and person2 moving down
		
		dp[r1][c1][c2] = max + res;
		
		return dp[r1][c1][c2];
	}

}
