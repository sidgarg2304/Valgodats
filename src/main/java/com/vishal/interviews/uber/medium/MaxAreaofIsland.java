package com.vishal.interviews.uber.medium;

public class MaxAreaofIsland {

	public static void main(String[] args) {

	}

	public int maxAreaOfIsland(int[][] grid) {

		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				res = Math.max(res, area(grid, i, j));
			}
		}
		return res;
	}

	int area(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0;
		return 1 + area(grid, i - 1, j) + area(grid, i + 1, j) + area(grid, i, j - 1) + area(grid, i, j + 1);
	}

}
