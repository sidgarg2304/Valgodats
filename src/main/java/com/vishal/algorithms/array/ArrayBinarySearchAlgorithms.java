package com.vishal.algorithms.array;

import java.util.Arrays;

public class ArrayBinarySearchAlgorithms {

	//1 2 3 4 5 6 7 8 9 10
	public static void main(String[] args) {

		int[] a = {2,3,10 };
//		searchRotated(a, 2);
		int [] b = {1, 4,5,6,7,8,9};
		System.out.println(findKth(a, b, 9, 0,2,0,6));

//		findMin(a);
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
	
	//
	public static double findMedian(int []a , int [] b){
		int m = a.length;
		int n = b.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	
	public static int findKth(int A[], int B[], int k, 
			int aStart, int aEnd, int bStart, int bEnd) {
		 
			int aLen = aEnd - aStart + 1;
			int bLen = bEnd - bStart + 1;
		 
			// Handle special cases
			if (aLen == 0)
				return B[bStart + k];
			if (bLen == 0)
				return A[aStart + k];
			if (k == 0)
				return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
		 
			int aMid = aLen * k / (aLen + bLen); // a's middle count
			int bMid = k - aMid - 1; // b's middle count
		 
		// make aMid and bMid to be array index
			aMid = aMid + aStart;
			bMid = bMid + bStart;
//			aMid = (aStart + aEnd)/2;
//			bMid = (bStart + bEnd)/2;
			
			System.out.println("finding k " + k);
			for(int i = aStart; i<= aEnd; i++){
				System.out.print(A[i]);
			}
			System.out.println("amid " + A[aMid]);
			
			for(int i = bStart; i<= bEnd; i++){
				System.out.print(B[i]);
			}
			System.out.println("bmid " + B[bMid]);
		 
			if (A[aMid] > B[bMid]) {
				k = k - (bMid - bStart + 1);
				aEnd = aMid;
				bStart = bMid + 1;
			} else {
				k = k - (aMid - aStart + 1);
				bEnd = bMid;
				aStart = aMid + 1;
			}
		 
			return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
		}

}
