package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {

	}

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});

		for (int j = 0; j < matrix[0].length; j++) {
			minHeap.offer(new int[] { 0, j, matrix[0][j] });
		}

		while (k > 1) {
			int[] cur = minHeap.poll();
			if (cur[0] < matrix.length - 1) {
				minHeap.offer(new int[] { cur[0] + 1, cur[1], matrix[cur[0] + 1][cur[1]] });
			}
			k--;
		}

		return minHeap.peek()[2];

	}
}
