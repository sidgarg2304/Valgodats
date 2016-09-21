package com.vishal.algorithms.sort;

import java.util.Arrays;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] a = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("Before sorting is " + Arrays.toString(a));
		mergeSort(a);
		System.out.println("After Merge sorting is " + Arrays.toString(a));

		int[] a1 = { 1, 8, 5, 6, 9, 10, 2, 3 };
		System.out.println("Before sorting is " + Arrays.toString(a1));
		quickSort(a1);
		System.out.println("After quick sorting is " + Arrays.toString(a1));
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
	
	static void quickSort(int [] a){
		quickSort(a, 0, a.length-1);
	}
	
	static void quickSort(int [] a, int s, int e){
		if(s < e){			
			int p = partition(a, s, e);
			System.out.println("parition array is " + Arrays.toString(a));
			quickSort(a, s, p);
			quickSort(a, p+1, e);
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
		System.out.println("p is " + p);
		return p;
	}
	
	static void swap(int [] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
