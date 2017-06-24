package com.vishal.interviews.programcreek;

public class RemoveDuplicatesfromSortedArrayI {

	public static void main(String[] args) {

		System.out.println(removeDuplicatesNaive(new int[] { 1, 1, 2 }));
	}

	public static int removeDuplicatesNaive(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int r = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[r++] = A[i];
			}
		}

		return r;
	}

}
