package com.vishal.interviews.leetcodereremaining.medium;

public class RotateFunction {

	public static void main(String[] args) {

	}

	public int maxRotateFunction(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int sum = 0;
		int F = 0;
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			F += i * A[i];
		}
		max = F;

		for (int i = A.length - 1; i >= 0; i--) {
			F = F + sum - (A.length * A[i]);
		}
		return max;
	}

}
