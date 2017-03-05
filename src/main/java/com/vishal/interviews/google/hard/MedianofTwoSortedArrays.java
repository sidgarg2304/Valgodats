package com.vishal.interviews.google.hard;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * 
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * 
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

	}

	/**
	 * Explanation
	 * 
	 * The key point of this problem is to ignore half part of A and B each step
	 * recursively by comparing the median of remaining A and B:
	 * 
	 * if (aMid < bMid) Keep [aRight + bLeft]
	 * 
	 * else Keep [bRight + aLeft]
	 * 
	 * As the following: time=O(log(m + n))
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1)
			return B[bStart + k - 1];
		if (bStart > B.length - 1)
			return A[aStart + k - 1];
		if (k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length)
			aMid = A[aStart + k / 2 - 1];
		if (bStart + k / 2 - 1 < B.length)
			bMid = B[bStart + k / 2 - 1];

		if (aMid < bMid)
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight
																					 // + bLeft
		else
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight
																					 // + aLeft
	}

	/**
	 * Share my iterative solution with O(log(min(n, m))) This is my iterative
	 * solution using binary search. The main idea is to find the approximate
	 * location of the median and compare the elements around it to get the final
	 * result.
	 * 
	 * do binary search. suppose the shorter list is A with length n. the runtime
	 * is O(log(n)) which means no matter how large B array is, it only depends
	 * on the size of A. It makes sense because if A has only one element while B
	 * has 100 elements, the median must be one of A[0], B[49], and B[50] without
	 * check everything else. If A[0] <= B[49], B[49] is the answer; if B[49] <
	 * A[0] <= B[50], A[0] is the answer; else, B[50] is the answer.
	 * 
	 * After binary search, we get the approximate location of median. Now we
	 * just need to compare at most 4 elements to find the answer. This step is
	 * O(1).
	 * 
	 * the same solution can be applied to find kth element of 2 sorted arrays.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArraysIterative(int A[], int B[]) {
		int n = A.length;
		int m = B.length;
		// the following call is to make sure len(A) <= len(B).
		// yes, it calls itself, but at most once, shouldn't be
		// consider a recursive solution
		if (n > m)
			return findMedianSortedArrays(B, A);

		// now, do binary search
		int k = (n + m - 1) / 2;
		int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
		while (l < r) {
			int midA = (l + r) / 2;
			int midB = k - midA;
			if (A[midA] < B[midB])
				l = midA + 1;
			else
				r = midA;
		}

		// after binary search, we almost get the median because it must be
		// between
		// these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

		// if (n+m) is odd, the median is the larger one between A[l-1] and
		// B[k-l].
		// and there are some corner cases we need to take care of.
		int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
		if (((n + m) & 1) == 1)
			return (double) a;

		// if (n+m) is even, the median can be calculated by
		// median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
		// also, there are some corner cases to take care of.
		int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
		return (a + b) / 2.0;
	}

}
