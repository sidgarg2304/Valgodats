package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class BestMeetingPoint {

	public static void main(String[] args) {

		// System.out.println(minTotalDistance(new int[][] { { 1, 0, 0, 0, 1 }, {
		// 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } }));
		System.out.println(minTotalDistance(new int[][] { { 1, 1 } }));
	}

	public static int minTotalDistance(int[][] grid) {
		
		if (grid == null || grid.length == 0) {
			return 0;
		}

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		int sum = 0;
		for (int i : rows) {
			sum += Math.abs(i - rows.get(rows.size() / 2));
		}
		Collections.sort(cols);
		for (int i : cols) {
			sum += Math.abs(i - cols.get(cols.size() / 2));
		}

		return sum;
	}

	public static int minTotalDistanceBFS(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int totalStudents = 0;
		int[][] distanceFromAllHouses = new int[grid.length][grid[0].length];
		int[][] numOfHousesReachable = new int[grid.length][grid[0].length];

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 1) {
					continue;
				}
				totalStudents++;
				numOfHousesReachable[i][j]++;

				Queue<int[]> queue = new LinkedList<>();
				boolean[][] visisted = new boolean[grid.length][grid[0].length];
				queue.offer(new int[] { i, j });
				visisted[i][j] = true;
				int dist = 0;
				while (!queue.isEmpty()) {
					int size = queue.size();
					for (int s = 0; s < size; s++) {
						int[] cur = queue.poll();

						for (int d = 0; d < dirs.length; d++) {
							int x = dirs[d][0] + cur[0];
							int y = dirs[d][1] + cur[1];

							if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visisted[x][y]) {
								continue;
							}

							visisted[x][y] = true;
							distanceFromAllHouses[x][y] += dist + 1;
							numOfHousesReachable[x][y]++;
							queue.offer(new int[] { x, y });
						}
					}
					dist++;
				}
			}
		}
		System.out.println("totalStudents is " + totalStudents);

		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(distanceFromAllHouses[i]));
		}

		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(numOfHousesReachable[i]));
		}
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (numOfHousesReachable[i][j] == totalStudents) {
					minDistance = Math.min(minDistance, distanceFromAllHouses[i][j]);
				}
			}
		}

		return minDistance;

	}

}
