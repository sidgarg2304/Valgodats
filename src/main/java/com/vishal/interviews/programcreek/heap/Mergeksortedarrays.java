package com.vishal.interviews.programcreek.heap;

import java.util.*;

public class Mergeksortedarrays {

	public static void main(String[] args) {

	}

	public static int[] mergeKSortedArray(int[][] arr) {

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int totalLen = 0;

		for (int i = 0; i < arr.length; i++) {
			totalLen += arr[i].length;
			minHeap.offer(new int[] { arr[i][0], i, 0 });
		}

		int[] res = new int[totalLen];
		int r = 0;
		while (!minHeap.isEmpty()) {
			int[] cur = minHeap.poll();
			res[r++] = cur[0];

			int[] curArr = arr[cur[1]];
			if (cur[2] < curArr.length - 1) {
				minHeap.offer(new int[] { curArr[cur[2] + 1], cur[1], cur[2] + 1 });
			}
		}

		return res;

	}

}
