package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;

/**
 * 576. Out of Boundary Paths
 * 
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the
 * ball, you can move the ball to adjacent cell or cross the grid boundary in
 * four directions (up, down, left, right). However, you can at most move N
 * times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.
 *
 */
public class OutofBoundaryPaths {

	public static void main(String[] args) {
		System.out.println(findPaths(2, 2, 2, 0, 0));
		System.out.println(findPaths(1, 3, 3, 0, 1));
	}

	public static int findPaths(int m, int n, int N, int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });		
		int res = 0;
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int level = 0;

		while (!queue.isEmpty()) {

			if (level > N) {
				break;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();

				for (int d = 0; d < dirs.length; d++) {
					int x = cur[0] + dirs[d][0];
					int y = cur[1] + dirs[d][1];

					if (x < 0 || y < 0 || x >= m || y >= n) {
						if (1 + level <= N) {
							res++;
						}
						continue;
					}
					
					queue.offer(new int[] { x, y });
				}
			}
			level++;
		}
		return res;
	}
}
