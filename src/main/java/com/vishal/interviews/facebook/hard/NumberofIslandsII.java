package com.vishal.interviews.facebook.hard;

import java.util.*;

public class NumberofIslandsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		
		List<Integer> result = new ArrayList<>();
		if (m <= 0 || n <= 0)
			return result;

		int count = 0; // number of islands
		int[] parent = new int[m * n]; // one island = one tree
		Arrays.fill(parent, -1);

		for (int[] p : positions) {
			int root = n * p[0] + p[1]; // assume new point is isolated island
			parent[root] = root; // add new island
			count++;

			for (int[] dir : dirs) {
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				int nb = n * x + y;
				// since neighbor island is not found, no need to merge
				if (x < 0 || x >= m || y < 0 || y >= n || parent[nb] == -1)
					continue;

				int rootNb = findIsland(parent, nb);
				if (root != rootNb) { // if neighbor is in another island
					parent[root] = rootNb; // union two islands
					root = rootNb; // current tree root = joined tree root
					count--;
				}
			}

			result.add(count);
		}
		return result;
	}

	public int findIsland(int[] parent, int id) {

		if (id == parent[id]) {
			return id;
		}
		parent[id] = findIsland(parent, parent[id]);
		return parent[id];
	}

}
