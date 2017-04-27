package com.vishal.interviews.google.medium;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1

Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {

	public static void main(String[] args) {

	}
	
	static void updateMatrixWithshortestDistance(int[][] m) {

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					m[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i< dir.length;i++){
				int x = cur[0] + dir[i][0];
				int y = cur[1] + dir[i][1];
				
				if(x < 0 || y< 0 || x >= m.length || y>= m[0].length || m[x][y] >= m[cur[0]][cur[1]] +1){
					continue;
				}
				
				queue.offer(new int[]{x,y});
				m[x][y] = m[cur[0]][cur[1]] +1;
			}
		}
	}
	
	public List<List<Integer>> updateMatrixBFS(List<List<Integer>> matrix) {
		int m = matrix.size();
		int n = matrix.get(0).size();

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix.get(i).get(j) == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix.get(i).set(j, Integer.MAX_VALUE);
				}
			}
		}

		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] d : dirs) {
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				if (r < 0 || r >= m || c < 0 || c >= n || matrix.get(r).get(c) <= matrix.get(cell[0]).get(cell[1]) + 1)
					continue;
				queue.add(new int[] { r, c });
				matrix.get(r).set(c, matrix.get(cell[0]).get(cell[1]) + 1);
			}
		}

		return matrix;
	}
	
	/**
	 * Java 33ms solution with two sweeps in O(n) In the first sweep, we visit
	 * each entry in natural order and answer[i][j] = min(Integer.MAX_VALUE,
	 * min(answer[i - 1][j], answer[i][j - 1]) + 1). in the second sweep, we
	 * visit each entry in reverse order and answer[i][j] = min(answer[i][j],
	 * min(answer[i + 1][j], answer[i][j + 1]) + 1).
	 */

	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		List<List<Integer>> answer = new LinkedList();
		if (matrix.size() == 0)
			return answer;
		int[][] array = new int[matrix.size()][matrix.get(0).size()];
		int i = 0, j = 0;
		for (List<Integer> list : matrix) {
			for (Integer x : list) {
				if (x == 0) {
					array[i][j] = 0;
				} else {
					int left = Integer.MAX_VALUE - 1, top = Integer.MAX_VALUE - 1;
					if (i - 1 >= 0)
						top = array[i - 1][j];
					if (j - 1 >= 0)
						left = array[i][j - 1];
					array[i][j] = Math.min(Integer.MAX_VALUE - 1, Math.min(top, left) + 1);
				}
				j++;
			}
			j = 0;
			i++;
		}
		for (int k = array.length - 1; k >= 0; k--) {
			for (int m = array[0].length - 1; m >= 0; m--) {
				if (array[k][m] != 0 && array[k][m] != 1) {
					int down = Integer.MAX_VALUE - 1, right = Integer.MAX_VALUE - 1;
					if (k + 1 < array.length)
						down = array[k + 1][m];
					if (m + 1 < array[0].length)
						right = array[k][m + 1];
					array[k][m] = Math.min(array[k][m], Math.min(down, right) + 1);
				}
			}
		}
		for (int[] l : array) {
			List<Integer> tmp = new LinkedList();
			for (int n : l) {
				tmp.add(n);
			}
			answer.add(tmp);
		}
		return answer;
	}

}
