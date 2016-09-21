package com.vishal.algorithms.array;

import java.util.Arrays;

public class ArrayBinarySearchAlgorithms {

	public static void main(String[] args) {

		int[] a = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
		searchRotated(a, 2);

		findMin(a);
	}

	// 7 8 9 1 2 3 4 5 6
	//

	public static void findMin(int[] a) {
		System.out.println("Min in the array " + Arrays.toString(a) + " is " + findMin(a, 0, a.length - 1));
	}

	public static int findMin(int[] a, int s, int e) {

		if (a[s] < a[e]) {
			return a[s];
		}

		int m = (s + e) / 2;

		if (a[m] > a[s]) {
			int leftMin = a[s];
			int rightMin = findMin(a, m + 1, e);
			return (leftMin < rightMin) ? leftMin : rightMin;
		} else {
			int rightMin = a[m];
			int leftMin = findMin(a, s, m - 1);
			return (leftMin < rightMin) ? leftMin : rightMin;
		}
	}

	public static void searchRotated(int[] a, int t) {
		searchRotated(a, 0, a.length - 1, t);
	}

	public static void searchRotated(int[] a, int s, int e, int t) {

		if (s > e) {
			return;
		}

		int m = (s + e) / 2;

		if (a[m] == t) {
			System.out.println("Element " + t + " found at " + m);
		}

		// t is not present in mid, so no need to include m in further searches
		if (a[m] >= a[s]) {
			// Left part is un-rotated
			if (t <= a[m] && t >= a[s]) {
				searchRotated(a, s, m - 1, t);
			} else {
				searchRotated(a, m + 1, e, t);
			}
		} else {
			// right part is un-rotated
			if (t >= a[m] && t <= a[s]) {
				searchRotated(a, m + 1, e, t);
			} else {
				searchRotated(a, s, m - 1, t);
			}
		}
	}

}
