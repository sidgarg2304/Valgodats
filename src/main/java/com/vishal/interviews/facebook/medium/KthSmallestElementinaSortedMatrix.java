package com.vishal.interviews.facebook.medium;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kthSmallest(int[][] matrix, int k) {

		if(matrix == null || matrix.length == 0){
			return -1;
		}
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int j = 0; j < matrix[0].length; j++) {
			minHeap.offer(new int[] { matrix[0][j], 0, j });
		}

		while (k > 1) {
			int[] cur = minHeap.poll();
			int x = cur[1];
			int y = cur[2];
			if (x < matrix.length - 1) {
				minHeap.offer(new int[] { matrix[x + 1][y], x + 1, y });
			}
			k--;
		}
		
		return minHeap.poll()[0];
	}

}
