package com.vishal.interviews.topinterviewquestions.easy;

import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {

	}

	public int countPrimes(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				for (int j = 2; j * i < n; j++) {
					primes[i * j] = false;
				}
				count++;
			}
		}
		return count;
	}

}
