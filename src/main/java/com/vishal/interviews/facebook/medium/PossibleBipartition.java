package com.vishal.interviews.facebook.medium;

import java.util.*;

public class PossibleBipartition {

	public static void main(String[] args) {

	}

	public boolean possibleBipartition(int N, int[][] dislikes) {

		Map<Integer, Integer> colorMap = new HashMap<>();
		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			adjList.put(i, new ArrayList<>());
		}
		for (int[] dislike : dislikes) {
			adjList.get(dislike[0]).add(dislike[1]);
			adjList.get(dislike[1]).add(dislike[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (!colorMap.containsKey(i) && !dfs(i, 0, colorMap, adjList)) {
				return false;
			}
		}

		return true;
	}

	boolean dfs(int node, int color, Map<Integer, Integer> colorMap, Map<Integer, List<Integer>> adjList) {

		if (colorMap.containsKey(node)) {
			return colorMap.get(node) == color;
		}
		colorMap.put(node, color);

		for (int ne : adjList.get(node)) {
			if (!dfs(ne, color ^ 1, colorMap, adjList)) {
				return false;
			}
		}
		return true;
	}

}
