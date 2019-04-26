package com.vishal.interviews.uber.medium;

import java.util.*;

public class WallsandGates {

	public static void main(String[] args) {

	}

	public void wallsAndGates(int[][] rooms) {

		if(rooms == null || rooms.length == 0) {
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int x = cur[0] + dirs[d][0];
				int y = cur[1] + dirs[d][1];

				if (x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length && rooms[x][y] != -1
						&& rooms[cur[0]][cur[1]] + 1 < rooms[x][y]) {
					rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
					queue.offer(new int[] { x, y });
				}
			}
		}

	}

}
