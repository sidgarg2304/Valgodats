package com.vishal.datastructures.graph;

import java.util.*;

public class UnionFindAlgorithms {

	public static void main(String[] args) {

		int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
		System.out.println(findNumOfConnectedComponentsInGraph(5, edges));
	}

	static int[] parent;

	static int findNumOfConnectedComponentsInGraph(int n, int[][] edges) {

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i< edges.length;i++){
			union(edges[i][0], edges[i][1]);
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i< n;i++){
			set.add(find(i));
		}

		
		return set.size();
	}
	
	static void union(int i, int j){		
		parent[find(i)]  =find(j);
	}

	static int find(int i) {
		if (parent[i] == i) {
			return i;
		}

		parent[i] = find(parent[i]);
		return parent[i];
	}

}
