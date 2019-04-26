package com.vishal.interviews.uber.hard;

import java.util.*;

public class NumberofIslandsII {

	public static void main(String[] args) {

	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();

		if (m <= 0 || n <= 0) {
			return res;
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int numIslands = 0;
		// sets or islands
		int[] sets = new int[m * n];
		// since initially we do not have all nodes, we initialize to -1
		Arrays.fill(sets, -1);

		for (int[] pos : positions) {
			int x = pos[0];
			int y = pos[1];

			int node = n * x + y;
			numIslands++;

			for (int d = 0; d < dirs.length; d++) {
				int neiX = pos[0] + dirs[d][0];
				int neiY = pos[1] + dirs[d][1];
				int neiNode = n * neiX + neiY;

				if (neiX <= 0 || neiY <= 0 || neiX > m || neiY > n || sets[neiNode] == -1) {
					continue;
				}
				
				int set1 = findSet(sets, node);
				int set2 = findSet(sets, neiNode);
				
				if(set1 != set2) {
					sets[set1] = set2;					
					numIslands--;
				}
			}
			res.add(numIslands);
		}

		return res;
	}
	
	int findSet(int[] sets, int node) {
		if(sets[node] == node) {
			return node;
		}
		
		sets[node] = findSet(sets, sets[node]);
		return sets[node];
	}

}
