package com.vishal.interviews.uber.medium;

public class BombEnemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxKilledEnemies(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}
		int res = 0;
		int[] cols = new int[grid[0].length];
		int row = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W') {
					continue;
				}

				if (i == 0 || grid[i - 1][j] == 'W') {
					cols[j] = findEnemiesInCol(grid, i, j);
				}

				if (j == 0 || grid[i][j - 1] == 'W') {
					row = findEnemiesInRow(grid, i, j);
				}

				if (grid[i][j] == '0') {
					res = Math.max(res, row + cols[j]);
				}
			}
		}
		return res;
	}

	int findEnemiesInCol(char[][] grid, int r, int c) {

		int res = 0;
		for (int i = r; i < grid.length; i++) {
			if (grid[i][c] == 'W') {
				break;
			}
			if (grid[i][c] == 'E') {
				res++;
			}
		}
		return res;
	}

	int findEnemiesInRow(char[][] grid, int r, int c) {

		int res = 0;
		for (int j = c; j < grid[0].length; j++) {
			if (grid[r][j] == 'W') {
				break;
			}
			if (grid[r][j] == 'E') {
				res++;
			}
		}
		return res;
	}

}
