package com.vishal.interviews.google.easy;

public class ValidMountainArray {

	public static void main(String[] args) {
		ValidMountainArray v = new ValidMountainArray();
		v.validMountainArray(new int[] { 0, 3, 2, 1 });
	}

	public boolean validMountainArray(int[] A) {

		if (A == null || A.length == 0) {
			return false;
		}

		boolean inc = false;
		boolean dec = false;

		for (int i = 1; i < A.length; i++) {
			int diff = A[i] - A[i - 1];

			if (dec && diff >= 0) {
				return false;
			}

			if (!inc && diff <= 0) {
				return false;
			}

			if (diff > 0) {
				inc = true;
			}

			if (diff < 0) {
				dec = true;
			}

		}
		return inc && dec;
	}

}
