package com.vishal.interviews.amazon.qae.easy;

import java.util.*;

/**
 * Find out the prime numbers in 1 to 100
 *
 */
public class PrimeNumbersList {

	public static void main(String[] args) {

		System.out.println(primeNumbers(100));
	}

	static List<Integer> primeNumbers(int n) {
		List<Integer> res = new ArrayList<>();

		boolean[] notPrimes = new boolean[n + 1];
		
		for (int i = 2; i <= n; i++) {
			if (!notPrimes[i]) {
				res.add(i);
				for(int j = 2; i *j <= n;j++){
					notPrimes[i*j] = true;
				}
			}
		}		

		return res;
	}
}
