package com.vishal.interviews.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {

		if (maze == null || maze.length == 0) {
			return 0;
		}

		int[][] length = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				length[i][j] = Integer.MAX_VALUE;
			}
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start[0], start[1] });
		length[start[0]][start[1]] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();			

			for (int d = 0; d < dirs.length; d++) {
				int x = cur[0];
				int y = cur[1];
				int curLength = length[cur[0]][cur[1]];

				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dirs[d][0];
					y += dirs[d][1];
					curLength++;
				}
				x -= dirs[d][0];
				y -= dirs[d][1];
				curLength--;

				if (curLength < length[x][y]) {
					length[x][y] = curLength;
					queue.offer(new int[] { x, y });
				}

			}
		}
		return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
				: length[destination[0]][destination[1]];
	}

}
