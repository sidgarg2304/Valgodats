package com.vishal.interviews.uber.medium;

import java.util.*;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {

	}

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for (int j = 0; j < matrix[0].length; j++) {
			minHeap.offer(new int[] { 0, j, matrix[0][j] });
		}

		for (int i = 0; i < k - 1; i++) {
			int[] cur = minHeap.poll();
			int r = cur[0];
			int c = cur[1];
			if (r + 1 < matrix.length) {
				minHeap.offer(new int[] { r + 1, c, matrix[r + 1][c] });
			}
		}
		return minHeap.poll()[2];
	}

}
