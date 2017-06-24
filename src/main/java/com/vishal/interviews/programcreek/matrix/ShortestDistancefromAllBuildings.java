package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class ShortestDistancefromAllBuildings {

	public static void main(String[] args) {

	}

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return -1;
		}

		int[][] numOfBuildings = new int[grid.length][grid[0].length];
		int[][] distFromAllBuildings = new int[grid.length][grid[0].length];

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		int totalBuildings = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 1) {
					continue;
				}
				totalBuildings++;
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j });
				boolean[][] visited = new boolean[grid.length][grid[0].length];

				visited[i][j] = true;
				int dist = 0;
				while (!queue.isEmpty()) {
					for (int s = 0; s < queue.size(); s++) {
						int[] cur = queue.poll();

						for (int d = 0; d < dirs.length; d++) {
							int x = cur[0] + dirs[d][0];
							int y = cur[1] + dirs[d][0];

							if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y]
									|| grid[x][y] != 0) {
								continue;
							}

							visited[x][y] = true;
							numOfBuildings[x][y]++;
							distFromAllBuildings[x][y] += dist + 1;
							queue.offer(new int[] { x, y });
						}
					}
					dist++;
				}

			}
		}

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && numOfBuildings[i][j] == totalBuildings) {
					minDistance = Math.min(minDistance, distFromAllBuildings[i][j]);
				}
			}
		}
		return minDistance;
	}

}
