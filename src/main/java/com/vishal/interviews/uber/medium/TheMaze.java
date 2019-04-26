package com.vishal.interviews.uber.medium;

import java.util.*;

public class TheMaze {

	public static void main(String[] args) {

	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);

		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (destination[0] == cur[0] && destination[1] == cur[1]) {
				return true;
			}

			for (int d = 0; d < dirs.length; d++) {

				int x = cur[0] + dirs[d][0];
				int y = cur[1] + dirs[d][1];

				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1) {
					x += dirs[d][0];
					y += dirs[d][1];
				}

				x -= dirs[d][0];
				y -= dirs[d][1];

				if (!visited[x][y]) {
					visited[x][y] = true;
					queue.offer(new int[] { x, y });
				}
			}
		}
		return false;
	}

}
