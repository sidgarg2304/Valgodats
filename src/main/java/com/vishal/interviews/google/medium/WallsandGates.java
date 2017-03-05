package com.vishal.interviews.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * 
 * 
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsandGates {

	public static void main(String[] args) {

	}
	
	public void wallsAndGatesBFS(int[][] rooms) {
      if (rooms.length == 0 || rooms[0].length == 0) return;
      Queue<int[]> queue = new LinkedList<>();
      for (int i = 0; i < rooms.length; i++) {
          for (int j = 0; j < rooms[0].length; j++) {
              if (rooms[i][j] == 0) queue.add(new int[]{i, j});
          }
      }
      while (!queue.isEmpty()) {
          int[] top = queue.remove();
          int row = top[0], col = top[1];
          if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
              rooms[row - 1][col] = rooms[row][col] + 1;
              queue.add(new int[]{row - 1, col});
          }
          if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
              rooms[row + 1][col] = rooms[row][col] + 1;
              queue.add(new int[]{row + 1, col});
          }
          if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
              rooms[row][col - 1] = rooms[row][col] + 1;
              queue.add(new int[]{row, col - 1});
          }
          if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
              rooms[row][col + 1] = rooms[row][col] + 1;
              queue.add(new int[]{row, col + 1});
          }
      }
  }
	
	public void wallsAndGatesDFS(int[][] rooms) {
	    for (int i = 0; i < rooms.length; i++)
	        for (int j = 0; j < rooms[0].length; j++)
	            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
	}

	private void dfs(int[][] rooms, int i, int j, int d) {
	    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
	    rooms[i][j] = d;
	    dfs(rooms, i - 1, j, d + 1);
	    dfs(rooms, i + 1, j, d + 1);
	    dfs(rooms, i, j - 1, d + 1);
	    dfs(rooms, i, j + 1, d + 1);
	}

	public static final int[] d = {0, 1, 0, -1, 0};

	public void wallsAndGatesMultiEndBFS(int[][] rooms) {
		if (rooms.length == 0)
			return;
		int m = rooms.length, n = rooms[0].length;

		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (rooms[i][j] == 0)
					queue.offer(i * n + j); // Put gates in the queue

		while (!queue.isEmpty()) {
			int x = queue.poll();
			int i = x / n, j = x % n;
			for (int k = 0; k < 4; ++k) {
				int p = i + d[k], q = j + d[k + 1]; // empty room
				if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
					rooms[p][q] = rooms[i][j] + 1;
					queue.offer(p * n + q);
				}
			}
		}
	}		

	public void wallsAndGatesNaiveBFS(int[][] rooms) {
		if (rooms.length == 0)
			return;
		for (int i = 0; i < rooms.length; ++i)
			for (int j = 0; j < rooms[0].length; ++j)
				if (rooms[i][j] == 0)
					bfs(rooms, i, j);
	}

	private void bfs(int[][] rooms, int i, int j) {
		int m = rooms.length, n = rooms[0].length;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(i * n + j); // Put gate in the queue
		while (!queue.isEmpty()) {
			int x = queue.poll();
			i = x / n;
			j = x % n;
			for (int k = 0; k < 4; ++k) {
				int p = i + d[k], q = j + d[k + 1];
				if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] > rooms[i][j] + 1) {
					rooms[p][q] = rooms[i][j] + 1;
					queue.offer(p * n + q);
				}
			}
		}
	}		

	public void wallsAndGatesDFS2(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++)
			for (int j = 0; j < rooms[0].length; j++)
				if (rooms[i][j] == 0)
					dfs(rooms, i, j);
	}

	public void dfs(int[][] rooms, int i, int j) {
		for (int k = 0; k < 4; ++k) {
			int p = i + d[k], q = j + d[k + 1];
			if (0 <= p && p < rooms.length && 0 <= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
				rooms[p][q] = rooms[i][j] + 1;
				dfs(rooms, p, q);
			}
		}
	}
}

class WallsandGatesBeautifulSolution {
	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0)
					bfs(rooms, i, j);
			}
		}
	}

	public void bfs(int[][] rooms, int i, int j) {
		for (int[] d : dir) {
			if (i + d[0] >= 0 && i + d[0] < rooms.length && j + d[1] >= 0 && j + d[1] < rooms[0].length
					&& rooms[i + d[0]][j + d[1]] > rooms[i][j] + 1) {
				rooms[i + d[0]][j + d[1]] = rooms[i][j] + 1;
				bfs(rooms, i + d[0], j + d[1]);
			}
		}
	}
}
