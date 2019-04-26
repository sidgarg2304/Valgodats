package com.vishal.interviews.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);

		boolean[][] visited = new boolean[maze.length][maze[0].length];
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			visited[cur[0]][cur[1]] = true;
			if (cur[0] == destination[0] && cur[1] == destination[1]) {
				return true;
			}

			for (int d = 0; d < dirs.length; d++) {
				int[] dir = dirs[d];

				int newX = cur[0] + dir[0];
				int newY = cur[1] + dir[1];

				while (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length && maze[newX][newY] != 1) {
					newX += dir[0];
					newY += dir[1];
				}
				
				newX -= dir[0];
				newY -= dir[1];
								
				if(!visited[newX][newY]){
					queue.offer(new int[]{newX, newY});
				}

			}
		}
		return false;

	}

}
