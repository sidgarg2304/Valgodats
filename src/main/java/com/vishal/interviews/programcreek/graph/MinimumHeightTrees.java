package com.vishal.interviews.programcreek.graph;

import java.util.*;

public class MinimumHeightTrees {

	public static void main(String[] args) {

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (adjList.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		while (n > 2) {
			n -= leaves.size();

			List<Integer> newLeaves = new ArrayList<>();

			for (int l : leaves) {
				for (int i = 0; i < n; i++) {
					if (adjList.get(i).contains(l)) {
						adjList.get(i).remove(l);
					}

					if (adjList.get(i).size() == 1) {
						newLeaves.add(i);
					}
				}
			}

			leaves = newLeaves;
		}

		return leaves;
	}

}
