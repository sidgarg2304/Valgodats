package com.vishal.interviews.programcreek.graph;

public class GraphValidTree {

	public static void main(String[] args) {

	}

	public boolean validTree(int n, int[][] edges) {

		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int[] edge : edges) {
			int p0 = find(parent, edge[0]);
			int p1 = find(parent, edge[0]);

			if (p0 == p1) {
				return false;
			}

			parent[p1] = p0;
		}

		return n - 1 == edges.length;
	}

	int find(int[] parent, int i) {
		if (parent[i] == i) {
			return i;
		}
		parent[i] = find(parent, parent[i]);

		return parent[i];
	}

}
