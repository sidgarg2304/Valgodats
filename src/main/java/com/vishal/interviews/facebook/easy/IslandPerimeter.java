package com.vishal.interviews.facebook.easy;

public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int total = 0;
		int overlap = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					total++;
					if (i >= 1 && grid[i - 1][j] == 1) {
						overlap++;
					}
					if (j >= 1 && grid[i][j - 1] == 1) {
						overlap++;
					}
				}
			}
		}
		return total * 4 - overlap * 2;
	}

}
