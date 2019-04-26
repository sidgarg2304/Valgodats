package com.vishal.interviews.google.easy;

public class SortArrayByParity {

	public static void main(String[] args) {

	}

	public int[] sortArrayByParity(int[] A) {

		int[] res = new int[A.length];

		int st = 0;
		int en = A.length - 1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				res[st++] = A[i];
			} else {
				res[en--] = A[i];
			}
		}
		return res;

	}

}
