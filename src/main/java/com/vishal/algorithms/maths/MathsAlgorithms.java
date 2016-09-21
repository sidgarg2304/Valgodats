package com.vishal.algorithms.maths;

public class MathsAlgorithms {

	public static void main(String[] args) {
//		System.out.println(isPerfectSquare(121));
		System.out.println(Math.random());
	}

	static void sortArrayWithOnesAndZeroes(int[] a) {
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

	static boolean isPerfectSquare(int n) {

		int i = 1;

		while (n > 0) {
			n -= i;
			i += 2;
		}

		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}
}
