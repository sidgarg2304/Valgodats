package com.vishal.interviews.amazon.qae.easy;

import java.util.*;

/**
 * Given 5 arrays each containing 10 elements with numbers random integers
 * between 1 and 10, merged them into 1 big sorted array.
 *
 */
public class MergeFiveArrays {

	public static void main(String[] args) {

		int[][] arrays = new int[5][10];
		arrays[0] = new int[] { 1, 4, 5, 6, 3, 8, 9, 10, 2, 7 };
		arrays[1] = new int[] { 1, 4, 5, 6, 3, 8, 9, 10, 2, 7 };
		arrays[2] = new int[] { 1, 4, 5, 6, 3, 8, 9, 10, 2, 7 };
		arrays[3] = new int[] { 1, 4, 5, 6, 3, 8, 9, 10, 2, 7 };
		arrays[4] = new int[] { 1, 4, 5, 6, 3, 8, 9, 10, 2, 7 };
		System.out.println(Arrays.toString(mergeFiveArrays(arrays)));
	}

	// solution works for K Arrays
	static int[] mergeFiveArrays(int[][] arrays) {
		int totalLength = 0;

		Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		for (int i = 0; i < arrays.length; i++) {
			Arrays.sort(arrays[i]);
			totalLength += arrays[i].length;
			minHeap.offer(new int[] { arrays[i][0], i, 0 });
		}

		int[] res = new int[totalLength];

		int k = 0;
		for (int i = 0; i < totalLength; i++) {
			int[] cur = minHeap.poll();

			res[k++] = cur[0];
			int newPos = cur[2] + 1;
			int arrPos = cur[1];
			if (newPos < arrays[arrPos].length) {
				minHeap.offer(new int[] { arrays[arrPos][newPos], arrPos, newPos });
			}
		}

		return res;
	}
}
