package com.vishal.interviews.uber.medium;

import java.util.*;

public class ZeroOneMatrix {

	public static void main(String[] args) {

	}

	public int[][] updateMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return new int[][] {};
		}
		
		int[][] res = new int[matrix.length][matrix[0].length];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					res[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int x = cur[0] + dirs[d][0];
				int y = cur[1] + dirs[d][1];

				if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 1
						&& res[x][y] > 1 + res[cur[0]][cur[1]]) {
					res[x][y] = 1 + res[cur[0]][cur[1]];
					queue.offer(new int[] { x, y });
				}
			}
		}
		return res;
	}

}
