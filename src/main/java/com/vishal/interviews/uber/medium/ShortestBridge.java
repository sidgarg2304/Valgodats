package com.vishal.interviews.uber.medium;

import java.util.*;

public class ShortestBridge {

	public static void main(String[] args) {
		ShortestBridge s = new ShortestBridge();
		s.shortestBridge(new int[][] { { 0, 1 }, { 1, 0 } });
	}

	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int shortestBridge(int[][] A) {

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[A.length][A[0].length];
		Outer: for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					dfs(A, i, j, queue, visited);
					break Outer;
				}
			}
		}

		int dist = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {

				int[] cur = queue.poll();

				for (int d = 0; d < dirs.length; d++) {
					int x = cur[0] + dirs[d][0];
					int y = cur[1] + dirs[d][1];

					if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || visited[x][y]) {
						continue;
					}

					if (A[x][y] == 1) {
						return dist;
					}

					visited[x][y] = true;
					queue.offer(new int[] { x, y });
				}

			}
			dist++;
		}
		return -1;
	}

	void dfs(int[][] A, int i, int j, Queue<int[]> queue, boolean[][] visited) {

		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][1];
			if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 0 || visited[x][y]) {
				continue;
			}
			visited[x][y] = true;
			queue.offer(new int[] { x, y });
			dfs(A, x, y, queue, visited);
		}
	}

}
