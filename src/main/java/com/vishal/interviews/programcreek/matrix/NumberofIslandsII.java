package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class NumberofIslandsII {

	public static void main(String[] args) {

	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {

		List<Integer> res = new ArrayList<>();
		int[] parent = new int[m * n];
		Arrays.fill(parent, -1);

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int cnt = 0;
		for (int[] p : positions) {

			cnt++;
			int root = n * p[0] + p[1];
			parent[root] = root;

			for (int d = 0; d < dirs.length; d++) {
				int x = p[0] + dirs[d][0];
				int y = p[1] + dirs[d][1];

				int newRoot = n * x + y;
				if (x < 0 || y < 0 || x >= m || y >= n || parent[newRoot] == -1) {
					continue;
				}

				int existingRoot = find(parent, newRoot);
				if (existingRoot != root) {
					cnt--;
					parent[root] = existingRoot;
					root = existingRoot;
				}

			}

			res.add(cnt);
		}

		return res;
	}

	int find(int[] parent, int i) {
		if (parent[i] == i) {
			return i;
		}
		parent[i] = find(parent, parent[i]);

		return parent[i];
	}

}
