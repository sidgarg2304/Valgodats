package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. Pacific Atlantic Water Flow Add to List
 * 
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * 1. The order of returned grid coordinates does not matter.
 * 
 * 2. Both m and n are less than 150.
 * 
 * Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {

	}

}

/**
 * 1. Two Queue and add all the Pacific border to one queue; Atlantic border to
 * another queue.
 * 
 * 2. Keep a visited matrix for each queue. In the end, add the cell visited by
 * two queue to the result. BFS: Water flood from ocean to the cell. Since water
 * can only flow from high/equal cell to low cell, add the neighboor cell with
 * height larger or equal to current cell to the queue and mark as visited.
 */
class PacificAtlanticWaterFlowBFSSolution {
	int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int n = matrix.length, m = matrix[0].length;
		// One visited map for each ocean
		boolean[][] pacific = new boolean[n][m];
		boolean[][] atlantic = new boolean[n][m];
		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) { // Vertical border
			pQueue.offer(new int[] { i, 0 });
			aQueue.offer(new int[] { i, m - 1 });
			pacific[i][0] = true;
			atlantic[i][m - 1] = true;
		}
		for (int i = 0; i < m; i++) { // Horizontal border
			pQueue.offer(new int[] { 0, i });
			aQueue.offer(new int[] { n - 1, i });
			pacific[0][i] = true;
			atlantic[n - 1][i] = true;
		}
		bfs(matrix, pQueue, pacific);
		bfs(matrix, aQueue, atlantic);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pacific[i][j] && atlantic[i][j])
					res.add(new int[] { i, j });
			}
		}
		return res;
	}

	public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
		int n = matrix.length, m = matrix[0].length;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
					continue;
				}
				visited[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}
}

class PacificAtlanticWaterFlowDFSSolution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int n = matrix.length, m = matrix[0].length;
		boolean[][] pacific = new boolean[n][m];
		boolean[][] atlantic = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
		}
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
			dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (pacific[i][j] && atlantic[i][j])
					res.add(new int[] { i, j });
		return res;
	}

	int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
		int n = matrix.length, m = matrix[0].length;
		if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
			return;
		visited[x][y] = true;
		for (int[] d : dir) {
			dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
		}
	}
}

/**
 * JAVA 17ms Solution, Simple and Clear, similar to Number of Islands's idea
The idea is as following:

First, we can separate Pacific and Atlantic ocean into two, they share the same idea. The only difference is the starting position.

Second, we think this problem in the opposite way: all the valid positions must have at least one path to connect to the ocean, so we start from the ocean to find out all the paths.

1, 1, 1, 1
1, 0, 0, 0
1, 0, 0, 0
1, 0, 0, 0

Then we create a new boolean[][] matrix like above, all the beaches is marked as True (1) in the beginning, which means they can connect to the ocean, then we explore from the beach to find out all the paths. The idea is the same for Pacific and Atlantic.

The last step is to use && to find positions satisfy both Pacific and Atlantic.

Here comes the solution:
 */
class PacificAtlanticWaterFlowsSimpleAndClearSolution {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;
		boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			pacific[i][0] = true;
			atlantic[i][matrix[0].length - 1] = true;
		}
		for (int j = 0; j < matrix[0].length; j++) {
			pacific[0][j] = true;
			atlantic[matrix.length - 1][j] = true;
		}
		for (int i = 0; i < matrix.length; i++) {
			explore(pacific, matrix, i, 0);
			explore(atlantic, matrix, i, matrix[0].length - 1);
		}
		for (int j = 0; j < matrix[0].length; j++) {
			explore(pacific, matrix, 0, j);
			explore(atlantic, matrix, matrix.length - 1, j);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pacific[i][j] && atlantic[i][j] == true)
					res.add(new int[] { i, j });
			}
		}
		return res;

	}

	private void explore(boolean[][] grid, int[][] matrix, int i, int j) {
		grid[i][j] = true;
		for (int d = 0; d < dx.length; d++) {
			if (i + dy[d] < grid.length && i + dy[d] >= 0 && j + dx[d] < grid[0].length && j + dx[d] >= 0
					&& grid[i + dy[d]][j + dx[d]] == false && matrix[i + dy[d]][j + dx[d]] >= matrix[i][j])
				explore(grid, matrix, i + dy[d], j + dx[d]);
		}
	}
}
/*
1.Naive solution:
    Standard dfs, which means for each point, we check if it can reach both pacific and atlantic, 
    for each point, we can possibly check all the rest of points, O(m*n * m*n)

2.A little improvement:
    What about we 4 hash tables, they keep track of all the points we know so far that 
        can reach atlantic
        cannot reach atlantic
        can reach pacific
        cannot reach pacific
    It's doable, still hit TLE, although I didn't hit TLE when not submitting the code, but running it using the provided testing environment

3.On the other hand, we can consider the flip side
    We can let the pacific and atlantic ocean "flow into" the matrix as much as possible,
    using 2 boolean arrays, one for each ocean. 
    The result are the points that are true in both boolean table
*/

//P.S Sometimes you choose an option just because the alternative is just worse.....
class PacificAtlanticWaterFlowsSimpleSolution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<int[]>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return result;
		boolean[][] pacific = new boolean[matrix.length][matrix[0].length]; // the
																								  // pacific
																								  // boolean
																								  // table
		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length]; // the
																									// atlantic
																									// booean
																									// table
		// initially, all the top and left cells are flooded with pacific water
		// and all the right and bottom cells are flooded with atlantic water
		for (int i = 0; i < matrix.length; i++) {
			pacific[i][0] = true;
			atlantic[i][matrix[0].length - 1] = true;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			pacific[0][i] = true;
			atlantic[matrix.length - 1][i] = true;
		}
		// we go around the matrix and try to flood the matrix from 4 side.
		for (int i = 0; i < matrix.length; i++) {
			boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
			boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
			water(pacific, pacificVisited, matrix, i, 0);
			water(atlantic, atlanticVisited, matrix, i, matrix[0].length - 1);
		}
		for (int i = 0; i < matrix[0].length; i++) {
			boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
			boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
			water(pacific, pacificVisited, matrix, 0, i);
			water(atlantic, atlanticVisited, matrix, matrix.length - 1, i);
		}
		// check the shared points among 2 tables
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					int[] element = { i, j };
					result.add(element);
				}
			}
		}
		return result;
	}

	// the flood function
	private void water(boolean[][] wet, boolean[][] visited, int[][] matrix, int i, int j) {
		wet[i][j] = true;
		visited[i][j] = true;
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			if (i + y[k] >= 0 && i + y[k] < matrix.length && j + x[k] >= 0 && j + x[k] < matrix[0].length
					&& !visited[i + y[k]][j + x[k]] && matrix[i + y[k]][j + x[k]] >= matrix[i][j]) {
				water(wet, visited, matrix, i + y[k], j + x[k]);
			}
		}
	}
}

