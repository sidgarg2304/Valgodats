package com.vishal.interviews.uber.medium;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslands(char[][] grid) {

		int res = 0;
		
		if(grid == null || grid.length == 0) {
			return res;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					grid[i][j] = 0;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	void dfs(char[][] grid, int i, int j) {

		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][1];

			if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
				grid[x][y] = '0';
				dfs(grid, x, y);
			}
		}
	}

}
