package com.vishal.interviews.facebook.easy;

public class MonotonicArray {

	public boolean isMonotonicSimple(int[] A) {

		if (A == null || A.length <= 1) {
			return true;
		}
		int i = 1;
		while (i < A.length && A[i] == A[i - 1]) {
			i++;
		}

		if (i == A.length) {
			return true;
		}

		boolean inc = A[i] > A[i - 1];
		for (i = 2; i < A.length; i++) {
			if (inc && A[i] < A[i - 1]) {
				return false;
			}

			if (!inc && A[i] > A[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean isMonotonic(int[] A) {

		if (A == null || A.length <= 1) {
			return true;
		}
		boolean inc = false;		
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				inc = A[i] > A[i-1];
				break;
			}
		}

		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				if (inc && A[i] < A[i - 1]) {
					return false;
				}

				if (!inc && A[i] > A[i - 1]) {
					return false;
				}
			}
		}
		return true;
	}
}
