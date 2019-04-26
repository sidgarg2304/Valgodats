package com.vishal.interviews.facebook.easy;

public class SquaresofaSortedArray {

	public static void main(String[] args) {

	}

	public int[] sortedSquares(int[] A) {

		if (A == null || A.length == 0) {
			return new int[] {};
		}

		int[] res = new int[A.length];

		int negIdx = 0;
		while (negIdx < A.length && A[negIdx] < 0) {
			negIdx++;
		}
		int posIdx = negIdx;
		negIdx = negIdx - 1;

		int r = 0;
		while (negIdx >= 0 && posIdx < A.length) {
			int negVal = A[negIdx] * A[negIdx];
			int posVal = A[posIdx] * A[posIdx];

			if (negVal < posVal) {
				res[r++] = negVal;
				negIdx--;
			} else {
				res[r++] = posVal;
				posIdx++;
			}
		}

		while (negIdx >= 0) {
			res[r++] = A[negIdx] * A[negIdx];
			negIdx--;
		}

		while (posIdx < A.length) {
			res[r++] = A[posIdx] * A[posIdx];
			posIdx++;
		}

		return res;
	}

}
