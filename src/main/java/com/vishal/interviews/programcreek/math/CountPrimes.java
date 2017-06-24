package com.vishal.interviews.programcreek.math;

import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {

	}

	public int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);

		int count = 0;

		for (int i = 2; i < n; i++) {
			if (prime[i]) {
				count++;
				for (int j = 2; i * j < n; j++) {
					prime[i * j] = false;
				}
			}
		}
		return count;

	}
}
