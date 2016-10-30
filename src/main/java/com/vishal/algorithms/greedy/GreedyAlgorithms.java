package com.vishal.algorithms.greedy;

public class GreedyAlgorithms {

	public static void main(String[] args) {
		testMaxRopesWithKLength();
		testFindMaxNonOverlappingIntervals();
	}

	public static void testMaxRopesWithKLength() {
		System.out.println(maxRopesWithKLength(new int[] { 1, 2, 3, 4, 1, 1, 3 }, 4));
	}

	public static void testFindMaxNonOverlappingIntervals() {
		System.out.println(findMaxNonOverlappingIntervals(new int[] { 1, 3, 7, 9, 9 }, new int[] { 5, 6, 8, 9, 10 }));
	}

	public static int maxRopesWithKLength(int[] ropes, int k) {

		int sum = 0;
		int maxRopes = 0;
		for (int i = 0; i < ropes.length; i++) {
			sum += ropes[i];
			if (sum >= k) {
				maxRopes++;
				sum = 0;
			}
		}
		return maxRopes;
	}

	/**
	 * same as merging overlapping intervals
	 * @param startIndices
	 * @param endIndices
	 * @return
	 */
	public static int findMaxNonOverlappingIntervals(int[] startIndices, int[] endIndices) {

		int i = 0;
		int maxNonOverlappingIntervals = 1;
		int endIndex = endIndices[0];
		while (i < startIndices.length) {
			// merge all overlapping with interval a[0] and b[0]
			while (i < startIndices.length && startIndices[i] <= endIndex) {
				i++;
			}
			if (i > startIndices.length - 1) {
				break;
			}
			maxNonOverlappingIntervals++;
			endIndex = endIndices[i];

		}

		return maxNonOverlappingIntervals;

	}

}
