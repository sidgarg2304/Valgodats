package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class NumberofConnectedComponentsinanUndirectedGraph {

	public static void main(String[] args) {

	}

	public int countComponents(int n, int[][] edges) {
		
		if(edges == null || edges.length == 0){
			return 0;
		}
		
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int[] edge : edges) {
			int p0 = find(parent, edge[0]);
			int p1 = find(parent, edge[1]);		

			parent[p1] = p0;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i< n; i++){			
			set.add(find(parent, i));
		}

		return set.size();
	}

	int find(int[] parent, int i) {
		if (parent[i] == i) {
			return i;
		}

		parent[i] = find(parent, i);
		return parent[i];
	}

}
