package com.vishal.interviews.facebook.hard;

import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	int max = 1;
	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i< cache.length; i++){
			Arrays.fill(cache[i], 1);
		}		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {	                
				dfs(matrix, i, j, cache);				
			}
		}
		return max;
	}

	void dfs(int[][] matrix, int i, int j, int[][] cache) {

		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][1];

			if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]
					&& cache[x][y] < 1 + cache[i][j]) {
				cache[x][y] = 1 + cache[i][j];
				max = Math.max(cache[x][y], max);
				dfs(matrix, x, y, cache);
			}
		}
	}

}
