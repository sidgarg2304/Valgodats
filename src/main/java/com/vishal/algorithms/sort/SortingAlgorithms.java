package com.vishal.algorithms.sort;

import java.util.Arrays;

import com.vishal.algorithms.interval.Interval;

public class SortingAlgorithms {

	public static void main(String[] args) {
		testBubbleSort();
		testInsertionSort();
		testMergeSort();
		testQuickSort();
		testCountSort();
		testBucketSort();
		String [] arr = new String[5];		
	}

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - 1; j++) {
				if (a[j - 1] > a[j]) {
					swap(a, j, j - 1);
				}
			}
		}
	}

	public static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					swap(a, j, i);
				}
			}
		}
	}

	public static void mergeSort(int[] a) {
		int[] t = new int[a.length];
		mergeSort(a, t, 0, a.length - 1);
	}

	private static void mergeSort(int[] a, int[] t, int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mergeSort(a, t, s, m);
			mergeSort(a, t, m + 1, e);
			merge(a, t, s, m, e);
		}
	}

	private static void merge(int[] a, int[] t, int s, int m, int e) {
		for (int i = s; i <= e; i++) {
			t[i] = a[i];
		}

		int i = s;
		int k = s;
		int j = m + 1;

		while (i <= m && j <= e) {
			if (t[i] < t[j]) {
				a[k] = t[i];
				i++;
			} else {
				a[k] = t[j];
				j++;
			}
			k++;
		}

		// If there are elements left on left side, add them to the end of k
		for (int p = i; p <= m; p++) {
			a[k++] = t[p];
		}
	}

	static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	static void quickSort(int[] a, int s, int e) {
		if (s < e) {
			int p = partition(a, s, e);
			quickSort(a, s, p - 1);
			quickSort(a, p + 1, e);
		}
	}

	// 1, 8, 5, 6, 9, 10, 2, 3
	// 1, 2, 5, 6, 9, 10, 8, 3
	static int partition(int[] a, int s, int e) {
		int pivot = a[e];

		int p = s;
		for (int i = s; i < e; i++) {
			if (a[i] < pivot) {
				swap(a, i, p);
				p++;
			}
		}
		swap(a, p, e);
		return p;
	}

	static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void countSort(int[] a, int numOfUniqueElements) {
		int[] countArr = new int[numOfUniqueElements];

		for (int i = 0; i < a.length; i++) {
			countArr[a[i]]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		int[] sorted = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int index = countArr[a[i]] - 1;
			countArr[a[i]]--;
			sorted[index] = a[i];
		}

		System.arraycopy(sorted, 0, a, 0, a.length);
	}

	public static void sortArrayWithOnesAndZeroes(int[] a) {
		int l = a.length;

		int sum = a[0];

		for (int i = 1; i < a.length; i++) {
			sum += a[i];
		}

		int ones = sum;
		int zeroes = sum - l;

		for (int j = 0; j < zeroes; j++) {
			a[j] = 0;
		}

		for (int j = sum - l + 1; j < ones; j++) {
			a[j] = 0;
		}
	}

	public static int maxGapUsingBucketSort(int[] a) {
		Interval[] buckets = new Interval[a.length + 1];

		int min = a[0];
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Interval(-1, -1);
		}

		double interval = (double) a.length / (max - min);

		for (int i = 0; i < a.length; i++) {
			int index = (int) ((a[i] - min) * interval);
			Interval curBucket = buckets[index];
			if (curBucket.getLow() == -1) {
				curBucket.setLow(a[i]);
				curBucket.setHigh(a[i]);
			} else {
				curBucket.setLow(Math.min(curBucket.getLow(), a[i]));
				curBucket.setHigh(Math.max(curBucket.getHigh(), a[i]));
			}
		}

		System.out.println("elements in the bucket are " + Arrays.toString(buckets));

		int maxGap = 0;
		Interval previousBucket = buckets[0];
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].getLow() != -1) {
				maxGap = Math.max(maxGap, buckets[i].getLow() - previousBucket.getHigh());
				previousBucket = buckets[i];
			}
		}
		return maxGap;
	}

	/**
	 * Test cases for all Sorting Algorithms
	 */
	public static void testBubbleSort() {
		int[] a = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("array before bubble sorting is " + Arrays.toString(a));
		SortingAlgorithms.bubbleSort(a);
		System.out.println("array after bubble sorting is " + Arrays.toString(a) + "\n");
	}

	public static void testInsertionSort() {
		int[] a = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("array before insertion sorting is " + Arrays.toString(a));
		SortingAlgorithms.insertionSort(a);
		System.out.println("array after insertion sorting is " + Arrays.toString(a) + "\n");
	}

	public static void testMergeSort() {
		int[] a = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("array before merge sorting is " + Arrays.toString(a));
		SortingAlgorithms.mergeSort(a);
		System.out.println("array after merge sorting is " + Arrays.toString(a) + "\n");
	}

	public static void testQuickSort() {
		int[] a = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("array before quick sorting is " + Arrays.toString(a));
		SortingAlgorithms.quickSort(a);
		System.out.println("array after quick sorting is " + Arrays.toString(a) + "\n");
	}

	public static void testCountSort() {
		int[] a = { 0, 1, 2, 0, 0, 1, 2, 0, 1 };
		System.out.println("array before count sorting is " + Arrays.toString(a));
		SortingAlgorithms.countSort(a, 3);
		System.out.println("array after count sorting is " + Arrays.toString(a) + "\n");
	}

	public static void testBucketSort() {
		int[] a = { 6, 1, 3, 4, 2, 8 };
		System.out.println("max gap between adjacent elements in the array " + Arrays.toString(a)
				+ " while sorted using bucket sorting is " + SortingAlgorithms.maxGapUsingBucketSort(a) + "\n");

	}
}
