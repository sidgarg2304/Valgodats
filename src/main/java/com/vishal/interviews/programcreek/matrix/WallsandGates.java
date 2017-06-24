package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class WallsandGates {

	public static void main(String[] args) {

	}

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}

		Queue<int[]> queue = new LinkedList<>();

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] != 0) {
					continue;
				}

				queue.offer(new int[] { i, j });

				int dist = 0;
				while (!queue.isEmpty()) {
					int size = queue.size();
					for (int s = 0; s < size; s++) {
						int[] cur = queue.poll();
						for (int d = 0; d < dirs.length; d++) {
							int x = dirs[d][0] + cur[0];
							int y = dirs[d][1] + cur[1];

							if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == 0
									|| rooms[x][y] == -1) {
								continue;
							}

							if (dist + 1 < rooms[x][y]) {
								rooms[x][y] = dist + 1;
								queue.offer(new int[] { x, y });
							}
						}
					}
					dist++;
				}
			}
		}
	}

}
