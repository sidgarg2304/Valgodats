package com.vishal.interviews.google.medium;

import java.util.*;

public class NumberofDistinctIslands {

	public static void main(String[] args) {
		NumberofDistinctIslands n = new NumberofDistinctIslands();
		System.out.println(n.numDistinctIslands(
				new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } }));
	}

	int[][] grid;

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public void explore(int r, int c, StringBuilder sb) {

		for (int d = 0; d < dirs.length; d++) {
			int x = r + dirs[d][0];
			int y = c + dirs[d][1];

			if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
				grid[x][y] = 0;
				sb.append(dirs[d][0] + "" + dirs[d][1]);
				explore(x, y, sb);
			}
		}
        sb.append("#");
	}

	public int numDistinctIslands(int[][] grid) {
		this.grid = grid;
		Set<String> shapes = new HashSet<String>();

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] != 1) {
					continue;
				}
				grid[r][c] = 0;
				StringBuilder shape = new StringBuilder();
				shape.append("0-0");
				explore(r, c, shape);
				if (shape.length() != 0) {
					shapes.add(shape.toString());
				}
			}
		}

		return shapes.size();
	}

}
