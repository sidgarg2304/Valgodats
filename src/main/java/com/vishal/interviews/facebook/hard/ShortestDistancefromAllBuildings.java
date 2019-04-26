package com.vishal.interviews.facebook.hard;

import java.util.*;

public class ShortestDistancefromAllBuildings {

	public static void main(String[] args) {

	}

	public int shortestDistance(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return -1;
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] totalNumOfBuildingsVisited = new int[grid.length][grid[0].length];
		int[][] distanceFromAllBuildings = new int[grid.length][grid[0].length];

		int totalBuildings = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 1) {
					continue;
				}
				boolean[][] visited = new boolean[grid.length][grid[0].length];
				totalBuildings++;
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] { i, j });

				int dist = 1;
				visited[i][j] = true;
				while (!queue.isEmpty()) {
					int s = queue.size();
					for (int l = 0; l < s; l++) {
						int[] cur = queue.poll();						

						for (int d = 0; d < dirs.length; d++) {
							int x = cur[0] + dirs[d][0];
							int y = cur[1] + dirs[d][1];

							if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y]
									|| grid[x][y] != 0) {
								continue;
							}
							visited[x][y] = true;
							totalNumOfBuildingsVisited[x][y]++;
							distanceFromAllBuildings[x][y] += dist;
							queue.offer(new int[] { x, y });
						}
					}
					dist++;
				}
			}
		}

		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0 && totalBuildings == totalNumOfBuildingsVisited[i][j] && distanceFromAllBuildings[i][j] < minDist){
					minDist = distanceFromAllBuildings[i][j];
				}
			}
		}
		return minDist == Integer.MAX_VALUE ? -1 : minDist;
	}
}
